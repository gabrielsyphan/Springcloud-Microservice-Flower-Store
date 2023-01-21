package com.syphan.springcloudmicroserviceflowerprovider.controller;

import com.syphan.springcloudmicroserviceflowerprovider.model.ProviderEntity;
import com.syphan.springcloudmicroserviceflowerprovider.model.dto.InfoDto;
import com.syphan.springcloudmicroserviceflowerprovider.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderService providerService;

    private final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/{state}")
    public List<ProviderEntity> getInfoByState(@PathVariable() String state) {
        this.logger.info("Get info by state: {}", state);
        return this.providerService.getInfoByState(state);
    }

    @PostMapping
    public ProviderEntity createInfo(@RequestBody InfoDto infoDto) {
        this.logger.info("Create info: {}", infoDto);
        return this.providerService.create(infoDto);
    }
}
