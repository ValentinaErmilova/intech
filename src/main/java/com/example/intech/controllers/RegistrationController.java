package com.example.intech.controllers;

import com.example.intech.DAO.UserDAO;
import com.example.intech.models.Role;
import com.example.intech.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

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
        User userDB = userDAO.findByUsername(user.getUsername());
        if (userDB != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.User));
        user.setActive(true);
        userDAO.save(user);
        return "redirect:/login";
    }
}
