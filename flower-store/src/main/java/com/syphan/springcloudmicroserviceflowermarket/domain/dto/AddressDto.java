package com.syphan.springcloudmicroserviceflowermarket.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AddressDto {

    @NotBlank(message = "Street is required")
    private String street;

    @Min(value = 1, message = "House number must be greater than 0")
    private int number;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "City is required")
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
