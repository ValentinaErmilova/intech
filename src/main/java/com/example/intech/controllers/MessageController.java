package com.example.intech.controllers;

import com.example.intech.DAO.MessageDAO;
import com.example.intech.models.Message;
import com.example.intech.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class MessageController {
    private final MessageDAO messageDAO;

    public MessageController(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @GetMapping("/main")
    public String index(Model model) {
        Iterable<Message> listOfMessages = messageDAO.findAll();
        model.addAttribute("some", "i love you Dima!");
        model.addAttribute("messages", listOfMessages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, Message message, Model model) {
        message.setUser(user);
        messageDAO.save(message);

        Iterable<Message> listOfMessages = messageDAO.findAll();
        model.addAttribute("messages", listOfMessages);

        return "main";
    }
}
