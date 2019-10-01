package com.example.intech.component;

import com.example.intech.DAO.UserDAO;
import com.example.intech.models.Role;
import com.example.intech.models.User;
import com.example.intech.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final UserDAO userDAO;

    public AppStartupRunner(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            User admin = new User();
            admin.setUsername(User.DEFAULT_ADMIN_NAME);
            admin.setPassword(User.DEFAULT_ADMIN_PASSWORD);
            new UserService(userDAO).create(admin, Role.Admin);
        } catch (RuntimeException e) {
            System.out.println(String.format("Cannot create user [message=%s]", e.getMessage()));
        }
    }
}