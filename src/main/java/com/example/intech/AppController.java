package com.example.intech;

import com.example.intech.DAO.MessageDAO;
import com.example.intech.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

//    @GetMapping("/greeting")
//    public String greeting(
//            @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @Autowired
    private MessageDAO messageDAO;

    @GetMapping
    public String index(Model model) {
        Iterable<Message> listOfMessages = messageDAO.findAll();
        model.addAttribute("some", "i love you Dima!");
        model.addAttribute("messages", listOfMessages);
        return "app-template";
    }

    @PostMapping
    public String add(@RequestParam String text, Model model) {
        Message message = new Message(text);
        messageDAO.save(message);

        Iterable<Message> listOfMessages = messageDAO.findAll();
        model.addAttribute("messages", listOfMessages);



        return "app-template";
    }
}