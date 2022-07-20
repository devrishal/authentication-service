package com.rds.api.rest;

import com.rds.api.swagger.RegisterUserResponse;
import com.rds.utility.vo.DeleteUser;
import com.rds.utility.vo.ProfileInformation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

public interface UserResource {
    @Operation(summary = "Get User Logs")
    @RegisterUserResponse
    @GetMapping(path = "/{username}/log", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@PathParam("username") String username);

    @Operation(summary = "Delete user logs")
    @RegisterUserResponse
    @DeleteMapping(path = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@RequestBody DeleteUser deleteUser);


    @Operation(summary = "Update User profile")
    @RegisterUserResponse
    @PutMapping(path = "/profile", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@RequestBody ProfileInformation profileInformation);


    @Operation(summary = "Confirm user account creation")
    @RegisterUserResponse
    @PutMapping(path = "/{username}/confirm", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> register(@PathParam("username") String username, @RequestParam String token);

}
