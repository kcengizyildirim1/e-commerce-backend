package com.workintech.ecommerce.restApi.converter;

import com.workintech.ecommerce.restApi.dto.RoleResponse;
import com.workintech.ecommerce.restApi.dto.UserCrudResponse;
import com.workintech.ecommerce.restApi.dto.UserRegisterResponse;
import com.workintech.ecommerce.restApi.entities.Address;
import com.workintech.ecommerce.restApi.entities.Role;
import com.workintech.ecommerce.restApi.entities.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.*;
import java.util.stream.Collectors;

public class DtoConverter {

    // USER RESPONSE
    public static UserRegisterResponse convertToUserResponse(User user, Role role){
        return new UserRegisterResponse(
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                role.getId());

    }

    public static List<UserRegisterResponse> convertToListUserResponse (List<User> userList, Role role) {
        List<User> users = new ArrayList<>();
        List<UserRegisterResponse> responses = new ArrayList<>();

        for (User user : userList){
            responses.add(new UserRegisterResponse(user.getFullName(), user.getEmail(),
                    user.getPassword(), role.getId()));
        }
        return responses;
    }

    // ROLE RESPONSE


    public static Set<RoleResponse> convertToListRoleResponse(Set<Role> roles){
        Set<RoleResponse> responses = new HashSet<>();
        for(Role role : roles){
            responses.add(new RoleResponse(role.getId(),role.getAuthority()));
        }
        return responses;
    }

    public static RoleResponse converToRoleResponse(Role role){
        return new RoleResponse(role.getId(), role.getAuthority());
    }

     //USER CRUD

}
