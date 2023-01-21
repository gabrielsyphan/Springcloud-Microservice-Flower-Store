package com.syphan.springcloudmicroserviceflowerprovider.model.dto;

public class ItemDto {

    private long id;
    private long quantity;

    private String name;

    public ItemDto() { }

    public ItemDto(long id, long quantity, String name) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
