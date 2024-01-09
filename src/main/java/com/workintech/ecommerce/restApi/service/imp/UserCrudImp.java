package com.workintech.ecommerce.restApi.service.imp;

import com.workintech.ecommerce.restApi.converter.DtoConverter;
import com.workintech.ecommerce.restApi.dto.UserCrudResponse;
import com.workintech.ecommerce.restApi.entities.User;
import com.workintech.ecommerce.restApi.repository.UserRepository;
import com.workintech.ecommerce.restApi.service.UserCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCrudImp implements UserCRUD {

    private UserRepository userRepository;
    @Autowired
    public UserCrudImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        //TODO Error Handling
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User delete(Long id) {
        User user = findById(id);
        userRepository.deleteById(user.getId());
        return user;
    }
}
