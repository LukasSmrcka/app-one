package com.lukas.appone.feigndemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppTwoCommunicatinController {


    @Autowired
    private AppTwoCommunicationService appTwoCommunicationService;

    @RequestMapping(value = "/call-app-two")
    public String callAppTwo() {

        String greeting = appTwoCommunicationService.getGreeting();

        StringBuilder configValues = new StringBuilder();
        configValues.append("App two responded: ")
                    .append(greeting)
                    .append("<br>");
        return configValues.toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/greet-app-two")
    public void greetAppTwo() {
        appTwoCommunicationService.postGreetingInBody("Good morning from app-one!!!!");
    }
}
