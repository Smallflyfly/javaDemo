package com.wochanye.demo.config.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @author fangpf
 * @date 2020/1/20 10:12
 */
@Configuration
public class JwtConfig {

    @Resource
    private Environment environment;

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(defaultFilter());
        registrationBean.addUrlPatterns("/");
        registrationBean.setName("jwtFilter");

    }

    @Bean("defaultFilter")
    public DefaultFilter defaultFilter(){
        Boolean access = !StringUtils.isBlank(environment.getProperty("client.access.need")) && Boolean.parseBoolean(environment.getProperty("client.access.need"));

    }
}
