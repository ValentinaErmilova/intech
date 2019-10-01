package com.example.intech.controllers;

import com.example.intech.DAO.MessageDAO;
import com.example.intech.models.Message;
import com.example.intech.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/messages")
public class MessageController {
    private final MessageDAO messageDAO;

    public MessageController(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @GetMapping
    public String messages(Model model) {
        Iterable<Message> listOfMessages = messageDAO.findAll();
        model.addAttribute("messages", listOfMessages);
        return "messages";
    }

    @PostMapping
    public String create(@AuthenticationPrincipal User user, Message message, Model model) {
        message.setUser(user);
        messageDAO.save(message);

        Optional<Message> listOfMessages = messageDAO.findById(user.getId());
        model.addAttribute("messages", listOfMessages);

        return "messages";
    }
}
