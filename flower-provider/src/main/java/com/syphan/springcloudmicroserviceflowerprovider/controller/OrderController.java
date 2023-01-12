package com.syphan.springcloudmicroserviceflowerprovider.controller;

import com.syphan.springcloudmicroserviceflowerprovider.model.InfoEntity;
import com.syphan.springcloudmicroserviceflowerprovider.model.OrderEntity;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(OrderController.class);

    @PostMapping
    public OrderEntity createOrder() {
        this.logger.info("Create order");
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1);
        orderEntity.setLeadTime(2);
        return orderEntity;
    }
}
