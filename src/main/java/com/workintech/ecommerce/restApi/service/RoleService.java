package com.workintech.ecommerce.restApi.service;

import com.workintech.ecommerce.restApi.dto.RoleResponse;
import com.workintech.ecommerce.restApi.entities.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    RoleResponse findById(Long id);
    Set<RoleResponse> findAllRole();
    RoleResponse save(Role role);
    RoleResponse delete(Long id);
}
