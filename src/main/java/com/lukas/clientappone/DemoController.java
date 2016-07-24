package com.lukas.clientappone;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RefreshScope
public class DemoController {

    @Value("${custom.localKey}")
    private String localKey;

    @Value("${custom.remoteKey}")
    private String remoteKey;

    @RequestMapping(value = "/config-demo")
    public String getConfigValues() {

        StringBuilder configValues = new StringBuilder();
        configValues.append("localKey: ")
                    .append(localKey)
                    .append("<br>")
                    .append("<br>")
                    .append("remoteKey: ")
                    .append(remoteKey);

        return configValues.toString();
    }
}
