package com.workintech.ecommerce.restApi.dto;

import com.workintech.ecommerce.restApi.entities.Address;
import com.workintech.ecommerce.restApi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCrudResponse {
    private Long id;
    private String fullName;
    private String phone;
    private List<Address> addresses;
    private Long roleId;

    public Address getPrimaryAddress() {
        return addresses != null && !addresses.isEmpty() ? addresses.get(0) : null;
    }
}
