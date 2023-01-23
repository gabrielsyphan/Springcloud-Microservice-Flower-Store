package com.syphan.springcloudmicroserviceflowermarket.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthenticationDto {

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String oassword;

    public AuthenticationDto(String email, String oassword) {
        this.email = email;
        this.oassword = oassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOassword() {
        return oassword;
    }

    public void setOassword(String oassword) {
        this.oassword = oassword;
    }
}
