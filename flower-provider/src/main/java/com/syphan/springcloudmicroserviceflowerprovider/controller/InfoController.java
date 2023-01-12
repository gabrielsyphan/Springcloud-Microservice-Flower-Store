package com.syphan.springcloudmicroserviceflowerprovider.controller;

import com.syphan.springcloudmicroserviceflowerprovider.model.InfoEntity;
import com.syphan.springcloudmicroserviceflowerprovider.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    private final InfoService infoService;

    private final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/{state}")
    public InfoEntity getInfoByState(@PathVariable() String state) {
        this.logger.info("Get info by state: {}", state);
        return this.infoService.getInfoByState(state);
    }
}
