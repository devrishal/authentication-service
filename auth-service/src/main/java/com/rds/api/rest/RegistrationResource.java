package com.rds.api.rest;

import com.rds.api.swagger.RegisterUserResponse;
import com.rds.utility.vo.Deregistration;
import com.rds.utility.vo.Registration;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public interface RegistrationResource {
    @Operation(summary = "User Registration")
    @RegisterUserResponse
    @PostMapping(path = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@Valid @RequestBody Registration registrationRequest, HttpServletRequest request);

    @Operation(summary = "User De-Registration")
    @RegisterUserResponse
    @PostMapping(path = "/de-register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@Valid @RequestBody Deregistration deRegistrationRequest);


}
