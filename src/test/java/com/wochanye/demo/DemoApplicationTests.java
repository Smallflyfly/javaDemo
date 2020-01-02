package com.wochanye.demo;

import com.dangdang.config.service.ConfigGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//

    @Resource
    private RestTemplate restTemplate;

//    @Resource
//    private DemoService demoService;
    @Resource
    private ConfigGroup configGroup;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDemo(){
        Integer a = 30;
        Integer b = 40;
        Integer c = 50;
        Integer d = 60;
        Integer e = (a < b && c < d) ? 150:250;
        System.out.println(e);
    }

    @Test
    public void testZK(){
        String url = configGroup.get("alibaba");
//        Boolean flag = configGroup.containsKey("baidu");
//        System.out.println(url);
//        System.out.println(flag);
//        String url = configGroup.get("baidu");
        System.out.println(url);
    }

    @Value("${MYSQL_DB_USERNAME}")
    private String name;

    @Test
    public void testNacos(){
        String mysqlName = name;
        System.out.println(mysqlName);
    }

}
