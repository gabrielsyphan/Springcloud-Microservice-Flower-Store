package com.syphan.springcloudmicroserviceflowermarket.controller;

import com.syphan.springcloudmicroserviceflowermarket.model.dto.OrderDto;
import com.syphan.springcloudmicroserviceflowermarket.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderDto orderDto) {
        this.orderService.createOrder(orderDto);
        return "Order created";
    }
}
