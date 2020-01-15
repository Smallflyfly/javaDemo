package com.wochanye.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
@Controller
public class WebSocketController {

    /**
     * 展示输出，但因为没有配置视图输出，会报500
     *
     * @return

    @RequestMapping(value = "webSocket", method = RequestMethod.GET)
    public String webSocketPage() {
        return "webSocket";
    }

    // 当浏览器向服务器发送请求的时候通过@MessageMapping 映射/welcome 这个地址 类似 RequestMapping
    @MessageMapping("/welcome")
    // 当服务器有消息的时候，会对订阅了@SendTo中的路径浏览器发送消息
    @SendTo("/topic/getResponse")
    public Object say(@RequestBody JSONObject reqData) throws InterruptedException {
        Thread.sleep(3000);
        JSONObject response = new JSONObject();
        response.put("responseMessage", "Welcome, " + reqData.getString("name"));
        return response;
    }
}
**/