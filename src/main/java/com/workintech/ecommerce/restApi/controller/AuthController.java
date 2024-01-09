package com.workintech.ecommerce.restApi.controller;



import com.workintech.ecommerce.restApi.dto.UserRegisterResponse;
import com.workintech.ecommerce.restApi.entities.User;
import com.workintech.ecommerce.restApi.service.imp.AuthenticationService;
import com.workintech.ecommerce.restApi.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AuthController {

    private AuthenticationService authenticationService;
    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterResponse userResponse) {
        authenticationService.registerUser(userResponse.getFullName(), userResponse.getEmail() ,
                userResponse.getPassword(), userResponse.getRoleId());
        return ResponseEntity.ok("User registered successfully.");
    }


    @GetMapping("/test")
    public String test(){
        return "Test";
    }

}
