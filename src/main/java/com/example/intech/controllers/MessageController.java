package com.example.intech.controllers;

import com.example.intech.DAO.MessageDAO;
import com.example.intech.DAO.UserDAO;
import com.example.intech.models.Message;
import com.example.intech.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/messages")
public class MessageController {
    private final MessageDAO messageDAO;
    private final UserDAO userDAO;

    public MessageController(MessageDAO messageDAO, UserDAO userDAO) {
        this.messageDAO = messageDAO;
        this.userDAO = userDAO;
    }

    @GetMapping
    public String users(@RequestParam(name = "id", required = false) Long toUserId, Model model) {
        if (toUserId != null) {
            model.addAttribute("messages", messageDAO.findByToUserId(toUserId));
        }
        model.addAttribute("users", userDAO.findAll());
        return "messages";
    }

    @PostMapping
    public String send(@AuthenticationPrincipal User user,
                         Message message,
                         @RequestParam(name = "id") Long toUserId,
                         Model model) {
        Optional<User> toUser = userDAO.findById(toUserId);
        message.setToUser(toUser.get());
        message.setFromUser(user);
        messageDAO.save(message);

        Optional<Message> listOfMessages = messageDAO.findById(user.getId());
        model.addAttribute("messages", listOfMessages);

        return "messages";
    }
}
