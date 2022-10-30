package com.example.demo.controllers;

import com.example.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistController {



    @GetMapping("/blog/usermain/useradd")
    public String blogAdd(Model model)
    {
        model.addAttribute("user", new User());
        return "blog-useradd";
    }


}
