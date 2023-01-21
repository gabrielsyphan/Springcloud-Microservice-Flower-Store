package com.syphan.springcloudmicroserviceflowermarket.service;

import com.syphan.springcloudmicroserviceflowermarket.client.ProviderClient;
import com.syphan.springcloudmicroserviceflowermarket.model.OrderEntity;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.ProviderDto;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.ProviderOrderInfoDto;
import com.syphan.springcloudmicroserviceflowermarket.model.enums.Status;
import com.syphan.springcloudmicroserviceflowermarket.repository.OrderRepository;
import jakarta.ws.rs.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final ProviderClient providerClient;

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(ProviderClient providerClient, OrderRepository orderRepository) {
        this.providerClient = providerClient;
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(OrderDto orderDto) {

        // Older way to call provider service: Import bean RestTemplate as final and uncomment the code below
        /* ResponseEntity<ProviderDto> response = this.restTemplate.exchange(
            "http://provider/info/" + orderDto.getAddress().getState(),
                HttpMethod.GET, null, ProviderDto.class
            );
        response.getBody().getAddress() */
        try {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setDestinationAddress(orderDto.getAddress().toString());
            orderEntity.setStatus(Status.CREATED);
            this.orderRepository.save(orderEntity);

            List<ProviderDto> providerDto = this.providerClient.getProviderInfo(orderDto.getAddress().getState());
            if(providerDto == null) {
                this.logger.error("Provider not found");
                return orderEntity;
            }

            ProviderOrderInfoDto providerOrderInfoDto = this.providerClient.createOrder(orderDto);
            if(providerOrderInfoDto == null) {
                this.logger.error("Could not create order");
                return orderEntity;
            }

            this.logger.info("Provider order info: {}", providerOrderInfoDto);
            orderEntity.setProviderOrderId(providerOrderInfoDto.getId());
            orderEntity.setLeadTime(providerOrderInfoDto.getLeadTime());
            orderEntity.setStatus(Status.IN_PROGRESS);
            this.orderRepository.save(orderEntity);

            return orderEntity;
        } catch (Exception e) {
            this.logger.error("Error when create order: {}", e.getMessage());
            throw e;
        }
    }

    public void deleteOrder(Long id) {
        this.orderRepository.delete(this.getOrder(id));
    }

    public OrderEntity getOrder(Long id) {
        return this.orderRepository.findById(id).orElseThrow(
            () -> new NotFoundException("Order not found")
        );
    }

    public OrderEntity updateOrder(OrderEntity orderEntity) {
        OrderEntity order = this.getOrder(orderEntity.getId());
        order.setDestinationAddress(orderEntity.getDestinationAddress());
        this.orderRepository.save(order);
        return order;
    }
}
