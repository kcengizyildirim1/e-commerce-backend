package com.workintech.ecommerce.restApi.service.imp;

import com.workintech.ecommerce.restApi.dto.UserRegisterResponse;
import com.workintech.ecommerce.restApi.entities.Role;
import com.workintech.ecommerce.restApi.entities.User;
import com.workintech.ecommerce.restApi.repository.RoleRepository;
import com.workintech.ecommerce.restApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String fullName, String email, String password, Long roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        System.out.println(optionalRole);
        Role userRole = new Role();
        if(optionalRole.isPresent()){
            userRole = roleRepository.findByName(optionalRole.get().getAuthority()).get();
        }
        System.out.println(userRole);
        Set<Role> roles = new HashSet<>();
        User user = new User();
        roles.add(userRole);
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setAuthorities(roles);
        return userRepository.save(user);
    }
}
