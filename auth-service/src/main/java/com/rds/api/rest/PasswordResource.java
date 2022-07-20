package com.rds.api.rest;

import com.rds.api.swagger.RegisterUserResponse;
import com.rds.utility.vo.Password;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface PasswordResource {
    @Operation(summary = "Forgot Password")
    @RegisterUserResponse
    @PostMapping(path = "/forgot-password/{usernameOrEmail}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@PathVariable("usernameOrEmail") @Parameter(description = "Email or Username"
            , example = "either jhondoe@gmail.com or jhondoe") String emailOrUsername, HttpServletRequest request);

    @Operation(summary = "Change user password")
    @RegisterUserResponse
    @PostMapping(path = "/change-password", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@ModelAttribute Password password, @RequestParam @Parameter(description = "token for change password") String token);
}
