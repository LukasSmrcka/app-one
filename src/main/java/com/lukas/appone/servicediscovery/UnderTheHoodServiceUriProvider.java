package com.lukas.appone.servicediscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UnderTheHoodServiceUriProvider {

    @Autowired
    DiscoveryClient client;

    public URI discoverServerUri(String serviceName) {
        List<ServiceInstance> services = client.getInstances(serviceName);
        Optional<ServiceInstance> serviceOptional = services.stream().findFirst();
        if(serviceOptional.isPresent()) {
            return serviceOptional.get().getUri();
        }
        return null;
    }

}
