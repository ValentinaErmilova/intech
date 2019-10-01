package com.example.intech.controllers;

import com.example.intech.DAO.UserDAO;
import com.example.intech.models.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAuthority('Admin')")
public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String search(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "users/search";
    }

    @GetMapping("{user}")
    public String edit(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("{user}")
    public String update(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "redirect:/users";
    }
}
