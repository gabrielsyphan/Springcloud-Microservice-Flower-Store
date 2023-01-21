package com.syphan.springcloudmicroserviceflowerprovider.model.dto;

public class InfoDto {

    private String name;

    private String state;

    private String address;

    public InfoDto() { }

    public InfoDto(String name, String state, String address) {
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
