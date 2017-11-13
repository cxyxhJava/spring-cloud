package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangxb on 2017/11/13.
 */

@RestController
public class TestController {
    private final Logger logger = Logger.getLogger(getClass());


    @Value("${server.port}")
    String port;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String testHi(@RequestParam String name){
        return "Hi" + name +" i am  "+port;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String testHi(){
        return "Hi";
    }
}
