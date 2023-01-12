package com.syphan.springcloudmicroserviceflowermarket.service;

import com.syphan.springcloudmicroserviceflowermarket.client.ProviderClient;
import com.syphan.springcloudmicroserviceflowermarket.model.OrderEntity;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.ProviderDto;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.ProviderOrderInfoDto;
import jakarta.ws.rs.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import com.syphan.springcloudmicroserviceflowermarket.model.dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final ProviderClient providerClient;

    @Autowired
    public OrderService(ProviderClient providerClient) {
        this.providerClient = providerClient;
    }

    public OrderEntity createOrder(OrderDto orderDto) {

        // Older way to call provider service: Import bean RestTemplate as final and uncomment the code below
        /* ResponseEntity<ProviderDto> response = this.restTemplate.exchange(
            "http://provider/info/" + orderDto.getAddress().getState(),
                HttpMethod.GET, null, ProviderDto.class
            );
        response.getBody().getAddress() */
        try {
            ProviderDto providerDto = this.providerClient.getProviderInfo(orderDto.getAddress().getState());
            if(providerDto == null) {
                this.logger.error("Provider not found");
                throw new NotFoundException("Provider not found");
            }

            ProviderOrderInfoDto providerOrderInfoDto = this.providerClient.createOrder(orderDto.getItems());
            if(providerOrderInfoDto == null) {
                this.logger.error("Could not create order");
                throw new NotFoundException("Could not create order");
            }

            this.logger.info("Provider order info: {}", providerOrderInfoDto);
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(providerOrderInfoDto.getId());
            orderEntity.setLeadTime(providerOrderInfoDto.getLeadTime());
            orderEntity.setDestinationAddress(orderDto.getAddress().toString());

            return orderEntity;
        } catch (Exception e) {
            this.logger.error("Error when create order: {}", e.getMessage());
            throw e;
        }
    }
}
