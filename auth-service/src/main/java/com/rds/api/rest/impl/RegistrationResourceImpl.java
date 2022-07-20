package com.rds.api.rest.impl;

import com.rds.api.rest.RegistrationResource;
import com.rds.utility.vo.Registration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet .http.HttpServletRequest;
@RestController
@RequestMapping("/v1")
@Validated
@RequiredArgsConstructor
public class RegistrationResourceImpl implements RegistrationResource {
    @Override
    public ResponseEntity<?> register(Registration registrationRequest, HttpServletRequest request) {
        return null ;
    }

}
