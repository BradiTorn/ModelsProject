package com.example.demo.controllers;


import com.example.demo.models.InfoPost;
import com.example.demo.repo.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OnController {

    @Autowired
    private InfoRepository infoRepository;

    @GetMapping("/blog/info")
    public String info(Model model)
    {
        Iterable<InfoPost> infos = infoRepository.findAll();
        model.addAttribute("infos", infos);
        return "blog-info";
    }

//    @GetMapping("/")
//    public String blogInfo(Model model)
//    {
//        Iterable<InfoPost> infos = infoRepository.findAll();
//        model.addAttribute("infos", infos);
//        return "blog-info";
//    }

    @PostMapping("/blog/info")
    public String infoPostAdd(@RequestParam String shapka,
                              @RequestParam String name,
                              @RequestParam String info,
                              @RequestParam String maintext,
                              @RequestParam int stat, Model model)
    {
        InfoPost infopost = new InfoPost(shapka, name, info, maintext, stat);
        infoRepository.save(infopost);
        return "redirect:/";
    }

    @PostMapping("/blog/info/result")
    public String blogResult(@RequestParam String name, Model model)
    {
        List<InfoPost> result = infoRepository.findByNameContains(name);
        model.addAttribute("result", result);
        return "blog-info";
    }

    @PostMapping("/blog/info/resultnocon")
    public String blogResultNoContains(@RequestParam String name, Model model)
    {
        List<InfoPost> resultnocon = infoRepository.findByName(name);
        model.addAttribute("resultnocon", resultnocon);
        return "blog-info";
    }

}
