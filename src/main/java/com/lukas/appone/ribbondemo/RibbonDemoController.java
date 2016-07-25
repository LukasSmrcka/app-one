package com.lukas.appone.ribbondemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class RibbonDemoController {


    private static final String APP_TWO_NAME = "app-two";

    @Autowired
    private UnderTheHoodServiceUriRibbonProvider uriProvider;

    @RequestMapping(value = "/ribbon")
    public String getConfigValues() {
        URI uri = uriProvider.provideServerUri(APP_TWO_NAME);

        StringBuilder configValues = new StringBuilder();
        configValues.append("Provided URI with the best availability: ")
                    .append(uri)
                    .append("<br>");
        return configValues.toString();
    }
}
