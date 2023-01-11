package com.syphan.springcloudmicroserviceflowermarket.service;

import com.syphan.springcloudmicroserviceflowermarket.model.dto.ProviderDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createOrder(OrderDto orderDto) {
        ResponseEntity<ProviderDto> response = this.restTemplate.exchange(
                "http://provider/info/" + orderDto.getAddress().getState(),
                HttpMethod.GET, null, ProviderDto.class
        );

        this.logger.info("Provider: " + response.getBody().getAddress());
    }
}
