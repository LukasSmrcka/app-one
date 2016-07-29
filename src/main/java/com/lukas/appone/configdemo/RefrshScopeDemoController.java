package com.lukas.appone.configdemo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RefreshScope
public class RefrshScopeDemoController {

    @Value("${custom.localKey}")
    private String localKey;

    @Value("${custom.color}")
    private String remoteKey;

    @RequestMapping(value = "/refresh-scope-demo")
    public String getConfigValues() {

        StringBuilder configValues = new StringBuilder();
        configValues.append("localKey: ")
                    .append(localKey)
                    .append("<br>")
                    .append("<br>")
                    .append("color: ")
                    .append(remoteKey);

        return configValues.toString();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("###########################################################");
        System.out.println("################## Singleton created!!! ###################");
        System.out.println("###########################################################");
    }
}
