package com.lukas.appone.ribbondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UnderTheHoodServiceUriRibbonProvider {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public URI provideServerUri(String serviceName) {
        ServiceInstance service = loadBalancerClient.choose(serviceName);
        return service.getUri();
    }

}
