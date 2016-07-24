package com.lukas.appone.feigndemo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("app-two")
//@FeignClient(url = "someUrl:port")
public interface AppTwoCommunicationService {

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    String getGreeting();

    @RequestMapping(method = RequestMethod.POST,
                    value = "/greeting",
                    consumes = "application/json")
    void postGreetingInBody (@RequestBody String greeting);
}
