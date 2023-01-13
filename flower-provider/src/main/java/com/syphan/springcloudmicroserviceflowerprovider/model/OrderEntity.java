package com.syphan.springcloudmicroserviceflowerprovider.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int leadTime;

    private String state;

    @ManyToMany
    private List<ItemEntity> items;

    private String address;

    public OrderEntity() { }

    public OrderEntity(long id, int leadTime, String state, String address,List<ItemEntity> items) {
        this.id = id;
        this.leadTime = leadTime;
        this.state = state;
        this.items = items;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
