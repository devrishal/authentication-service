package com.rds.utility.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Error {
    private int code;
    private String message;
}
