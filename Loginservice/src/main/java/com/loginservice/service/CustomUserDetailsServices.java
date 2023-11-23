package com.loginservice.service;

import java.util.Arrays;
import java.util.Collection;


import com.loginservice.model.User;
import com.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsServices  implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return new CustomUserDetails(
                user.getUsername(),
                user.getPassword(),
                authorities(),
                user.getFullname());
    }

    public Collection<? extends GrantedAuthority> authorities () {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

}