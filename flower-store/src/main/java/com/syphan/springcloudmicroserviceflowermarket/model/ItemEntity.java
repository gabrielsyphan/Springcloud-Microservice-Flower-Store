package com.syphan.springcloudmicroserviceflowermarket.model;

public class ItemEntity {

    private long id;
    private long quantity;

    public ItemEntity() { }

    public ItemEntity(long id, long quantity) {
        this.id = id;
        this.quantity = quantity;
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
}
