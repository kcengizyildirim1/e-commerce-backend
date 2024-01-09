package com.workintech.ecommerce.restApi.service;

import com.workintech.ecommerce.restApi.dto.UserCrudResponse;
import com.workintech.ecommerce.restApi.dto.UserRegisterResponse;
import com.workintech.ecommerce.restApi.entities.User;

import java.util.List;

public interface UserCRUD {
    User findById(Long id);
    List<User> findAll();
    User delete(Long id);
}
