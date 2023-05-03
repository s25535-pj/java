package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    private final ServiceClass serviceClass;

    public ServiceClass(ServiceClass serviceClass) {
        this.serviceClass = serviceClass;
    }
    public String logic(){
        return "Logic";
    }
}
