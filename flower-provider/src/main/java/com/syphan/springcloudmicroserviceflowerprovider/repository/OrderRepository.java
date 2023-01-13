package com.syphan.springcloudmicroserviceflowerprovider.repository;

import com.syphan.springcloudmicroserviceflowerprovider.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
