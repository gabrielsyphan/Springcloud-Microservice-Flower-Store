package com.syphan.springcloudmicroserviceflowermarket.controller;

import com.syphan.springcloudmicroserviceflowermarket.model.OrderEntity;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.OrderDto;
import com.syphan.springcloudmicroserviceflowermarket.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderDto orderDto) {
        this.logger.info("Create order: {}", orderDto);
        return this.orderService.createOrder(orderDto);
    }
}
