package com.syphan.springcloudmicroserviceflowerprovider.service;

import com.syphan.springcloudmicroserviceflowerprovider.model.OrderEntity;
import com.syphan.springcloudmicroserviceflowerprovider.model.dto.OrderDto;
import com.syphan.springcloudmicroserviceflowerprovider.repository.ProviderRepository;
import com.syphan.springcloudmicroserviceflowerprovider.repository.OrderRepository;
import jakarta.ws.rs.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProviderRepository infoRepository;

    private final Random random = new Random();

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    public OrderService(OrderRepository orderRepository, ProviderRepository infoRepository) {
        this.orderRepository = orderRepository;
        this.infoRepository = infoRepository;
    }

    public OrderEntity create(OrderDto orderDto) {
        try {
            this.logger.info("Create order: {}");

            if(this.infoRepository.findByState(orderDto.getAddress().getState()).isEmpty()) {
                this.logger.error("State not found");
                throw new NotFoundException("Provider not found");
            }

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setState(orderDto.getAddress().getState());
            orderEntity.setAddress(orderDto.getAddress().toString());
            orderEntity.setLeadTime(this.random.nextInt(10) + 1);
            orderEntity.setItems(orderDto.getItems());

            return this.orderRepository.save(orderEntity);
        } catch (Exception e) {
            this.logger.error("Error when create order: " + e.getMessage());
            throw e;
        }
    }

    public List<OrderEntity> getAllOrders() {
        this.logger.info("Get all orders");
        return this.orderRepository.findAll();
    }
}
