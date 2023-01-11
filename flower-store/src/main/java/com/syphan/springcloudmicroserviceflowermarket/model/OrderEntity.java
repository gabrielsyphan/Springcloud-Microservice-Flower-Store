package com.syphan.springcloudmicroserviceflowermarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderEntity {

    @Id
    private Long id;

    private int leadTime;

    private String destinationAddress;

    public OrderEntity() { }

    public OrderEntity(Long id, int leadTime, String destinationAddress) {
        this.id = id;
        this.leadTime = leadTime;
        this.destinationAddress = destinationAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
