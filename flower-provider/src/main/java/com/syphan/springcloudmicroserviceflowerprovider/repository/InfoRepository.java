package com.syphan.springcloudmicroserviceflowerprovider.repository;

import com.syphan.springcloudmicroserviceflowerprovider.model.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<InfoEntity, Long> {

    InfoEntity findByState(String state);
}
