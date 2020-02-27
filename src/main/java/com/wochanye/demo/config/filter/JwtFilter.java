package com.wochanye.demo.config.filter;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import com.wochanye.demo.config.Result;
import com.wochanye.demo.config.context.ClientContext;
import com.wochanye.demo.config.context.ClientInfo;
import com.wochanye.demo.constant.ConfigConsts;
import com.wochanye.demo.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fangpf
 * @date 2020/1/20 11:01
 */
@Slf4j
public class JwtFilter extends DefaultFilter {

    private List<Pattern> patterns = new ArrayList<>();

    private List<Pattern> defaultPatterns = new ArrayList<>();

    @Resource
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        fetchClientInfo(request);
        String url = request.getRequestURI();
        if (isIncludeUrl(url)){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        final String token = StringUtils.isNotBlank(request.getHeader(ConfigConsts.Auth.TOKEN_KEY)) ?
                request.getHeader(ConfigConsts.Auth.TOKEN_KEY) : request.getParameter(ConfigConsts.Auth.TOKEN_KEY);
        // OPTIONS请求返回200
        if (RequestMethod.OPTIONS.name().equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(servletRequest, servletResponse);
        } else { // 非OPTIONS请求，都要验证token信息
            if (StringUtils.isBlank(token)){
                log.error("token不能为空");
                responseUnauthorized(response);
                return;
            }
        }
        try {
            //token 验证  超时提醒 403
            Map<String, Claim> claims = jwtUtil.verifyToken(token);
            if (System.currentTimeMillis() > claims.get(ConfigConsts.Auth.TOKEN_EXPIRE_TIME).asLong()){
                responseAccessTimeout(response);
                return;
            }
            //验证 url 权限
            String userId = claims.get(ConfigConsts.Auth.TOKEN_ID_KEY).asString();
            if (!isDefaultInclude(url) && !canAccess(url, userId)){
                responseUnauthorized(response);
            }
        }catch (Exception e){
            log.error("unauthoried");
        }
    }

    /**
     * 获取客户端信息
     * @param request 请求
     * @return void
     */
    private void fetchClientInfo(HttpServletRequest request){
        // 获取请求头里的token信息
        String userAgent = request.getHeader(ConfigConsts.Client.USER_AGENT);
        System.out.println(userAgent);
        System.out.println("fangpf");
        ClientInfo clientInfo = new ClientInfo();
        if (StringUtils.isNotBlank(userAgent)){
            String[] clientInfoArr = userAgent.split(";");
            if (clientInfoArr.length >= 3){
                clientInfo.setSystemInfo(clientInfoArr[2]);
            }
            if (clientInfoArr.length >=4){
                clientInfo.setSystemInfo(clientInfoArr[3]);
            }
        }
        ClientContext.getClientInfo().set(clientInfo);
    }

    private Boolean isIncludeUrl(String url){
        if (url.contains("/swagger-ui.html")
        || url.contains("/swagger-resources")
        || url.contains("/v2/api-docs")
        || url.contains("/webjars/springfox-swagger-ui")){
            return true;
        }
        for (Pattern pattern:patterns){
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()){
                return true;
            }
        }
        return false;
    }

    private Boolean isDefaultInclude(String url){
        for (Pattern pattern:defaultPatterns){
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()){
                return true;
            }
        }
        return false;
    }

    private void responseUnauthorized(HttpServletResponse response) throws IOException {
        Result<Boolean> result = new Result<>(false);
        result.setCode(HttpServletResponse.SC_UNAUTHORIZED);
        result.setMessage("Unauthorized");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(JSONObject.toJSON(result).toString());
    }

    private void responseAccessTimeout(HttpServletResponse response) throws IOException {
        Result<Boolean> result = new Result<>(false);
        result.setCode(HttpServletResponse.SC_FORBIDDEN);
        result.setMessage("TimeOut");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(JSONObject.toJSON(result).toString());
    }

    private Boolean canAccess(String url, String userId){
        //to do
        return true;
    }
}
