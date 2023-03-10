package com.syphan.springcloudmicroserviceflowerprovider.repository;

import com.syphan.springcloudmicroserviceflowerprovider.model.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {

    List<ProviderEntity> findByState(String state);
}
