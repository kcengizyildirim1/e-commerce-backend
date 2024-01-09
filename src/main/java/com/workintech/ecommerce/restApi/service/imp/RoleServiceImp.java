package com.workintech.ecommerce.restApi.service.imp;

import com.workintech.ecommerce.restApi.converter.DtoConverter;
import com.workintech.ecommerce.restApi.dto.RoleResponse;
import com.workintech.ecommerce.restApi.entities.Role;
import com.workintech.ecommerce.restApi.repository.RoleRepository;
import com.workintech.ecommerce.restApi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponse findById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()){
            return DtoConverter.converToRoleResponse(optionalRole.get());
        }
        //TODO Error exception handling
        return null;
    }

    @Override
    public Set<RoleResponse> findAllRole() {
        return DtoConverter.convertToListRoleResponse(roleRepository.findAll().stream().collect(Collectors.toSet()));
    }

    @Override
    public RoleResponse save(Role role) {
        return DtoConverter.converToRoleResponse(roleRepository.save(role));
    }

    @Override
    public RoleResponse delete(Long id) {
        RoleResponse role = findById(id);
        roleRepository.deleteById(role.getId());
        return role;
    }
}
