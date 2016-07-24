package com.lukas.clientappone;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "custom")
public class ConfigurationPropertiesDemoController {

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    @RequestMapping(value = "/config-props-demo")
    public String getConfigValues() {

        StringBuilder configValues = new StringBuilder();
        configValues.append("Color: ")
                    .append(color)
                    .append("<br>");

        return configValues.toString();
    }
}
