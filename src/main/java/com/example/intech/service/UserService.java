package com.example.intech.service;

import com.example.intech.DAO.UserDAO;
import com.example.intech.models.Role;
import com.example.intech.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }

    public void create(User user, Role role) {
        User userDB = userDAO.findByUsername(user.getUsername());
        if (userDB != null) {
            throw new RuntimeException("User exists!");
        }
        user.setRoles(Collections.singleton(role));
        user.setActive(true);
        userDAO.save(user);
    }
}
