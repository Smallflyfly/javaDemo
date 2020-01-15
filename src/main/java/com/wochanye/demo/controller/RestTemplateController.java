package com.wochanye.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 通过封装okHttp3的RestTemplate请求数据的demo
 *
 * @author cuijie
 * @since 2018-07-24
 */
/**
@Controller
public class RestTemplateController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/cityWeather", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject cityWeather() {
        String data = restTemplate.getForObject("http://www.weather.com.cn/data/cityinfo/101210101.html", String.class);
        JSONObject weather = JSONObject.parseObject(data);
        data = restTemplate.getForObject("http://www.weather.com.cn/data/sk/101210101.html", String.class);
        JSONObject wind = JSONObject.parseObject(data);
        JSONObject result = new JSONObject();
        result.put("weather", weather);
        result.put("wind", wind);
        return result;
    }

    @RequestMapping(value = "/https", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject https() {
        JSONObject result = new JSONObject();
        String data = restTemplate.getForObject("https://blog.csdn.net/account090909/article/details/78872142", String.class);
        result.put("https", data);
        return result;
    }

}
**/