package com.syphan.springcloudmicroserviceflowermarket.controller;

import com.syphan.springcloudmicroserviceflowermarket.domain.dto.AuthenticationDto;
import com.syphan.springcloudmicroserviceflowermarket.domain.model.UserEntity;
import com.syphan.springcloudmicroserviceflowermarket.security.JwtTokenDto;
import com.syphan.springcloudmicroserviceflowermarket.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDto dto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getOassword());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        String jwtToken = this.tokenService.createJwtToken((UserEntity) authentication.getPrincipal());

        return ResponseEntity.ok(new JwtTokenDto(jwtToken));
    }
}
