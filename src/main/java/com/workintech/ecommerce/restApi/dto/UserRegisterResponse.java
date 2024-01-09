package com.workintech.ecommerce.restApi.dto;

import com.workintech.ecommerce.restApi.entities.Role;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegisterResponse {
    String fullName;
    @Valid String email; 
    String password;
    Long roleId;
}
