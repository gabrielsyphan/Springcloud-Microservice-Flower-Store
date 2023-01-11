package com.syphan.springcloudmicroserviceflowermarket.model.dto;

import com.syphan.springcloudmicroserviceflowermarket.model.Item;
import com.syphan.springcloudmicroserviceflowermarket.dto.AddressDto;

import java.util.List;

public class OrderDto {

    private List<Item> items;
    private AddressDto address;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
