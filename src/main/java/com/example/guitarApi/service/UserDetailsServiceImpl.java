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


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
    public String newUser(SignupRequest signupRequest) {
        User user = new User();
        user.setPassword(signupRequest.getPassword());
        user.setUserName(signupRequest.getUserName());
        return dataAccessLayer.newUserToDatabase(user);
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = dataAccessLayer.getUserFromDatabaseByName(userName);
        if (user == null) return null;
        return UserDetailsImpl.build(user);
    }
    public User loadUserEntityByUsername(String userName) throws UsernameNotFoundException {
        return dataAccessLayer.getUserFromDatabaseByName(userName);
    }
}
