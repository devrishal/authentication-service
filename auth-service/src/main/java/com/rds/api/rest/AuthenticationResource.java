package com.rds.api.rest;

import com.rds.api.swagger.RegisterUserResponse;
import com.rds.utility.vo.Login;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public interface AuthenticationResource {
    @Operation(summary = "Login to the application")
    @RegisterUserResponse
    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@Valid @ModelAttribute Login loginRequest);
}
