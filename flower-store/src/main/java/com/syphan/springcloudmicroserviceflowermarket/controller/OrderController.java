package com.syphan.springcloudmicroserviceflowermarket.controller;

import com.syphan.springcloudmicroserviceflowermarket.domain.OrderEntity;
import com.syphan.springcloudmicroserviceflowermarket.dto.OrderDto;
import com.syphan.springcloudmicroserviceflowermarket.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDto orderDto, UriComponentsBuilder uriComponentsBuilder) {
        this.logger.info("Create order: {}", orderDto);
        OrderEntity orderEntity = this.orderService.createOrder(orderDto);
        URI uri = uriComponentsBuilder.path("/order/{id}").buildAndExpand(orderEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(orderEntity); // return 201 status code
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        this.logger.info("Delete order: {}", id);
        this.orderService.deleteOrder(id);
        return ResponseEntity.noContent().build(); // return 204 status code
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable Long id) {
        this.logger.info("Get order: {}", id);
        return ResponseEntity.ok(this.orderService.getOrder(id)); // return 200 status code
    }

    @PutMapping
    public ResponseEntity<OrderEntity> updateOrder(@RequestBody OrderEntity orderEntity) {
        this.logger.info("Update order: {}", orderEntity);
        return ResponseEntity.ok(this.orderService.updateOrder(orderEntity)); // return 200 status code
    }
}
