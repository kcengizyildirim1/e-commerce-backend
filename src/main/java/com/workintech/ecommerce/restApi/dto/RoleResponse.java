package com.workintech.ecommerce.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RoleResponse {
    Long id;
    String authority;
}
