package com.syphan.springcloudmicroserviceflowerprovider.service;

import com.syphan.springcloudmicroserviceflowerprovider.model.ProviderEntity;
import com.syphan.springcloudmicroserviceflowerprovider.model.dto.InfoDto;
import com.syphan.springcloudmicroserviceflowerprovider.repository.ProviderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    private final Logger logger = LoggerFactory.getLogger(ProviderService.class);

    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<ProviderEntity> getInfoByState(String state) {
        List<ProviderEntity> infoEntity = this.providerRepository.findByState(state);
        if(infoEntity.isEmpty()) {
            this.logger.info("Info not found for state: {}", state);
        }

        this.logger.info("Get info by state: {}", infoEntity);
        return infoEntity;
    }

    public ProviderEntity create(InfoDto infoDto) {
        this.logger.info("Create info: {}", infoDto);

        ProviderEntity infoEntity = new ProviderEntity();
        infoEntity.setName(infoDto.getName());
        infoEntity.setAddress(infoDto.getAddress());
        infoEntity.setState(infoDto.getState());

        return this.providerRepository.save(infoEntity);
    }
}
