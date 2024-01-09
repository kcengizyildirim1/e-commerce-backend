package com.workintech.ecommerce.restApi.controller;

import com.workintech.ecommerce.restApi.dto.RoleResponse;
import com.workintech.ecommerce.restApi.entities.Role;
import com.workintech.ecommerce.restApi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    public RoleResponse save(@RequestBody Role role){
        return roleService.save(role);
    }
}
