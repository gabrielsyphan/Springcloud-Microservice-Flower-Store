package com.syphan.springcloudmicroserviceflowerprovider.service;

import com.syphan.springcloudmicroserviceflowerprovider.model.InfoEntity;
import com.syphan.springcloudmicroserviceflowerprovider.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private final InfoRepository infoRepository;

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public InfoEntity getInfoByState(String state) {
        return this.infoRepository.findByState(state);
    }
}
