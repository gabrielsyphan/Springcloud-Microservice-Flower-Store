package com.syphan.springcloudmicroserviceflowermarket.dto;

public class ProviderDto {

    private String name;

    private String state;

    private String address;

    public ProviderDto() { }

    public ProviderDto(String name, String state, String address) {
        this.name = name;
        this.state = state;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
