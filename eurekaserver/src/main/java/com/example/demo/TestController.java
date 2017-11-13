package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangxb on 2017/11/13.
 */

@RestController
public class TestController {
    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String testHi(){
        return "Hi";
    }
}
