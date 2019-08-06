package com.ivy.springboothello.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cloud.client.serviceregistry.Registration;

import java.util.List;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
     public String index() {
        ServiceInstance instance = serviceInstance();
        if (instance != null) {
            String result = "/hello, host:port=" + instance.getUri() + ", "
                    + "service_id:" + instance.getServiceId();
            logger.info(result);
        }

        return "Hello World ";
    }

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(itm.getPort() == 2001) {
                    return itm;
                }
            }
        }
        return null;
    }


}
