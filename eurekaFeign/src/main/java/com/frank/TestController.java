package com.frank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangxb on 2017/11/14.
 */
@RestController
public class TestController {
    @Autowired
    private TestInterface testInterface;

    @RequestMapping(method = RequestMethod.GET, value = "/hiFeign")
    public  Integer hiFeign(@RequestParam String name){
        return testInterface.hi(name);
    }

}
