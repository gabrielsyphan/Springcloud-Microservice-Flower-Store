package com.syphan.springcloudmicroserviceflowermarket.model.dto;

public class ProviderDto {

    private String address;

    public ProviderDto() { }

    public ProviderDto(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
