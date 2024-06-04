package com.example.guitarApi.service;

import com.example.guitarApi.dal.DataAccessLayer;
import com.example.guitarApi.dto.SignupRequest;
import com.example.guitarApi.models.User;
import com.example.guitarApi.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
    public String newUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUserName(signupRequest.getUserName());
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setRoles(signupRequest.getRoles());

        return dataAccessLayer.newUserToDatabase(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dataAccessLayer.getUserFromDatabaseByUsername(username);
        if (user == null) return null;
        return UserDetailsImpl.build(user);
    }

    public User loadUserEntityByUsername(String username) throws UsernameNotFoundException {
        return dataAccessLayer.getUserFromDatabaseByUsername(username);
    }
}
