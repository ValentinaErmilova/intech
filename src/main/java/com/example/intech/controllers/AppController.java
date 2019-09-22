package com.example.intech.controllers;

import com.example.intech.DAO.MessageDAO;
import com.example.intech.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @Autowired
    private MessageDAO messageDAO;

    @GetMapping("/main")
    public String index(Model model) {
        Iterable<Message> listOfMessages = messageDAO.findAll();
        model.addAttribute("some", "i love you Dima!");
        model.addAttribute("messages", listOfMessages);
        return "app-template";
    }

    @PostMapping("/main")
    public String add(Message message, Model model) {
        messageDAO.save(message);

        Iterable<Message> listOfMessages = messageDAO.findAll();
        model.addAttribute("messages", listOfMessages);

        return "app-template";
    }
}