package com.rds.utility.exception;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class AuthenticationServiceException extends RuntimeException {
    private String message;

    public AuthenticationServiceException(String message) {
        super(message);
    }
}
