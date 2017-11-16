package com.frank;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yangxb on 2017/11/14.
 */
@FeignClient("eurekaclient") //对应服务名
public interface TestInterface {

    @RequestMapping(method = RequestMethod.GET, value = "/hi")  //对应提供者url
    Integer hi(String name);


}
