package com.syphan.springcloudmicroserviceflowermarket.model.dto;

public class AddressDto {

    private String street;
    private int number;
    private String state;
    private String city;

    public AddressDto() { }

    public AddressDto(String street, int number, String state, String city) {
        this.street = street;
        this.number = number;
        this.state = state;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
