'package com.syphan.springcloudmicroserviceflowermarket.model;

import com.syphan.springcloudmicroserviceflowermarket.model.enums.Status;
import jakarta.persistence.*;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long providerOrderId;

    private int leadTime;

    private String destinationAddress;

    @Enumerated(EnumType.STRING)
    private Status status;

    public OrderEntity() { }

    public OrderEntity(Long id, Long providerOrderId, int leadTime, String destinationAddress, Status status) {
        this.id = id;
        this.providerOrderId = providerOrderId;
        this.leadTime = leadTime;
        this.destinationAddress = destinationAddress;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProviderOrderId() {
        return providerOrderId;
    }

    public void setProviderOrderId(Long providerOrderId) {
        this.providerOrderId = providerOrderId;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
'