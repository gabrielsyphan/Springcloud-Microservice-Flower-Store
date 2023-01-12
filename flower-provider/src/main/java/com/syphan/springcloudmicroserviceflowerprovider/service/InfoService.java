package com.syphan.springcloudmicroserviceflowerprovider.service;

import com.syphan.springcloudmicroserviceflowerprovider.model.InfoEntity;
import com.syphan.springcloudmicroserviceflowerprovider.repository.InfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private final InfoRepository infoRepository;

    private final Logger logger = LoggerFactory.getLogger(InfoService.class);

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public InfoEntity getInfoByState(String state) {
        InfoEntity infoEntity = this.infoRepository.findByState(state);
        if(!infoEntity) {
            this.logger.info("Info not found for state: {}", state);
            throw new RuntimeException("Info not found");
        }

        this.logger.info("Get info by state: {}", infoEntity);
        return infoEntity;
    }
}
