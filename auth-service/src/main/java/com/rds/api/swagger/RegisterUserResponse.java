package com.rds.api.swagger;

import com.rds.utility.vo.AuthResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Target({METHOD, ANNOTATION_TYPE, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User registered successfully",
                content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthResponse.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request, Mandatory Input missing",
                content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthResponse.class))),
        @ApiResponse(responseCode = "405", description = "Invalid method used",
                content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal system error, Please contact System Admin",
                content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthResponse.class)))
})
public @interface RegisterUserResponse {
}
