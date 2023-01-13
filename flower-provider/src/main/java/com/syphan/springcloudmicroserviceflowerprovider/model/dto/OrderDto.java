package com.syphan.springcloudmicroserviceflowerprovider.model.dto;

import com.syphan.springcloudmicroserviceflowerprovider.model.ItemEntity;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderDto {

    @NotNull
    private List<ItemEntity> items;

    @NotNull
    private AddressDto address;

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
