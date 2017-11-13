package com.frank;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yangxb on 2017/11/13.
 */

@RestController
public class TestController {
    private final Logger logger = Logger.getLogger(getClass());


    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return restTemplate.getForEntity("http://frank-client-01/add?a=10&b=20", Integer.class).getBody();
    }


    @Value("${server.port}")
    String port;


    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String testHi(@RequestParam String name){
        return "Hi" + name +" i am  "+port;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String testHi(){
        return "Hi";
    }
}
