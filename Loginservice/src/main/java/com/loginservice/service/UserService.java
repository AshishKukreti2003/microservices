package com.loginservice.service;


import com.loginservice.dto.UserDto;
import com.loginservice.model.User;

public interface UserService {

    User findByUsername(String username);
    User save (UserDto userDto);

}