package com.syphan.springcloudmicroserviceflowerprovider.service;

import com.syphan.springcloudmicroserviceflowerprovider.model.ItemEntity;
import com.syphan.springcloudmicroserviceflowerprovider.model.dto.ItemDto;
import com.syphan.springcloudmicroserviceflowerprovider.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final Logger logger = LoggerFactory.getLogger(ItemService.class.getName());

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> getAllItems() {
        return this.itemRepository.findAll();
    }

    public ItemEntity save(ItemDto itemDto) {
        try {
            this.logger.info("Save item: {}", itemDto);

            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setName(itemDto.getName());
            itemEntity.setQuantity(itemDto.getQuantity());

            return this.itemRepository.save(itemEntity);
        } catch (Exception e) {
            this.logger.error(e.getMessage());
            throw e;
        }
    }
}
