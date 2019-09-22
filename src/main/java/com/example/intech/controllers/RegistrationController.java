package com.example.intech.controllers;

import com.example.intech.DAO.UserDAO;
import com.example.intech.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userDB = userDAO.findByUsername(user.getUsername());
        if (userDB != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        user.setRole(User.Role.User);
        user.setActive(true);
        userDAO.save(user);
        return "redirect:/login";
    }
}
