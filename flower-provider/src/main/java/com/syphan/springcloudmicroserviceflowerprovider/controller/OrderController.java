package com.syphan.springcloudmicroserviceflowerprovider.controller;

import com.syphan.springcloudmicroserviceflowerprovider.model.OrderEntity;
import com.syphan.springcloudmicroserviceflowerprovider.model.dto.ItemDto;
import com.syphan.springcloudmicroserviceflowerprovider.model.dto.OrderDto;
import com.syphan.springcloudmicroserviceflowerprovider.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return this.orderService.create(orderDto);
    }

    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return this.orderService.getAllOrders();
    }
}
