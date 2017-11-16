package com.frank;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yangxb on 2017/11/13.
 */

@RestController
public class TestController {

    @Value("${spring.application.name}")
    String name;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "helloError")
    public String add() {
        return restTemplate.getForEntity("http://eurekaclient/add?a=10&b=20", String.class).getBody();
    }
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String Hi() {
        return restTemplate.getForEntity("http://eurekaclient/hi?name="+name, String.class).getBody();
    }

    public String helloError() {
        return "I am error";
    }

}
