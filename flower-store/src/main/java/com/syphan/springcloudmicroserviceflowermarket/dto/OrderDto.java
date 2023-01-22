package com.syphan.springcloudmicroserviceflowermarket.dto;

import com.syphan.springcloudmicroserviceflowermarket.domain.ItemEntity;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderDto {

    @NotNull(message = "{itemEntities.required}")
    private List<ItemEntity> itemEntities;

    @NotNull(message = "{address.required}")
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
