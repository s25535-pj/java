package com.example.jaz.service;

import org.springframework.web.client.RestTemplate;

public class RentalService {

    private final RestTemplate restTemplate;
    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
}
