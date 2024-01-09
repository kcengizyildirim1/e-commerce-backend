package com.workintech.ecommerce.restApi.controller;

import com.workintech.ecommerce.restApi.entities.User;
import com.workintech.ecommerce.restApi.service.UserCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/users")
public class UserController {

    private UserCRUD userCRUD;
    @Autowired
    public UserController(UserCRUD userCRUD) {
        this.userCRUD = userCRUD;
    }

    @GetMapping("/")
    public List<User> findAll(){
        return userCRUD.findAll();
    }

}
