package com.example.demo.controllers;


import com.example.demo.models.InfoPost;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/blog/usermain")
    public String UserMain(Model model)
    {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "blog-usermain";
    }

    @GetMapping("/blog/usermain/useradd")
    public String blogAdd(Model model)
    {
        return "blog-useradd";
    }

    @PostMapping("/blog/usermain/useradd")
    public String blogPostAdd(@RequestParam String login,
                              @RequestParam String password,
                              @RequestParam String phone,
                              @RequestParam String email,
                              @RequestParam String gender,Model model)
    {
        User user = new User(login, password, phone, email, gender);
        userRepository.save(user);
        return "redirect:/blog/usermain";
    }

    @PostMapping("/blog/usermain/useradd/result")
    public String blogResult(@RequestParam String login, Model model)
    {
        List<User> result = userRepository.findByLoginContains(login);
        model.addAttribute("result", result);
        return "blog-useradd";
    }

    @PostMapping("/blog/usermain/useradd/resultnocon")
    public String blogResultNoContains(@RequestParam String login, Model model)
    {
        List<User> resultnocon = userRepository.findByLogin(login);
        model.addAttribute("resultnocon", resultnocon);
        return "blog-useradd";
    }

}
