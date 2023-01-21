package com.syphan.springcloudmicroserviceflowermarket.model.dto;

import com.syphan.springcloudmicroserviceflowermarket.model.ItemEntity;

import java.util.List;

public class OrderDto {

    private List<ItemEntity> itemEntities;
    private AddressDto address;

    public List<ItemEntity> getItems() {
        return itemEntities;
    }

    public void setItems(List<ItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
