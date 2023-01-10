package com.syphan.springcloudmicroserviceflowerprovider.controller;

import com.syphan.springcloudmicroserviceflowerprovider.model.InfoEntity;
import com.syphan.springcloudmicroserviceflowerprovider.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/{state}")
    public InfoEntity getInfoByState(@PathVariable() String state) {
        return this.infoService.getInfoByState(state);
    }
}
