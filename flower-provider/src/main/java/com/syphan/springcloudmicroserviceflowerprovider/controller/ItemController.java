package com.syphan.springcloudmicroserviceflowerprovider.controller;

import com.syphan.springcloudmicroserviceflowerprovider.model.ItemEntity;
import com.syphan.springcloudmicroserviceflowerprovider.model.dto.ItemDto;
import com.syphan.springcloudmicroserviceflowerprovider.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemEntity> getAllItems() {
        return this.itemService.getAllItems();
    }

    @PostMapping
    public ItemEntity createItem(@RequestBody ItemDto itemDto) {
        return this.itemService.save(itemDto);
    }
}
