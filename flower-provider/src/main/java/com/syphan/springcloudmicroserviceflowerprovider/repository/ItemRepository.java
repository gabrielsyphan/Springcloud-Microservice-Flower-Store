package com.syphan.springcloudmicroserviceflowerprovider.repository;

import com.syphan.springcloudmicroserviceflowerprovider.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
