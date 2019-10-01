package com.example.intech.controllers;

import com.example.intech.DAO.UserDAO;
import com.example.intech.models.Role;
import com.example.intech.models.User;
import com.example.intech.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final UserDAO userDAO;

    public RegistrationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String create(User user, Model model) {
        try {
            new UserService(userDAO).create(user, Role.User);
        } catch (RuntimeException e) {
            String message = String.format("Cannot create user [message=%s]", e.getMessage());
            System.out.println(message);
            model.addAttribute("message", message);
            return "registration";
        }

        return "redirect:/login";
    }
}
