package com.syphan.springcloudmicroserviceflowermarket.domain.repository;

import com.syphan.springcloudmicroserviceflowermarket.domain.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
