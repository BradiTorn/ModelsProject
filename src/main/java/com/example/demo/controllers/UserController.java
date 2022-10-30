package com.example.demo.controllers;


import com.example.demo.models.InfoPost;
import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        model.addAttribute("user", new User());
        return "blog-useradd";
    }

    @PostMapping("/blog/usermain/useradd")
    public String blogPostAdd(@ModelAttribute("user")@Validated User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "blog-useradd";
        }
        userRepository.save(user);
        return "redirect:/blog/usermain";
    }

    @PostMapping("/blog/usermain/useradd/result")
    public String blogResult(@RequestParam String username, Model model)
    {
        List<User> result = userRepository.findByUsernameContains(username);
        model.addAttribute("result", result);
        return "blog-useradd";
    }

    @PostMapping("/blog/usermain/useradd/resultnocon")
    public String blogResultNoContains(@RequestParam String username, Model model)
    {
        List<User> resultnocon = userRepository.findByUsername(username);
        model.addAttribute("resultnocon", resultnocon);
        return "blog-useradd";
    }


    @GetMapping("/blog/usermain/{id}")
    public String userDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<User> post = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        model.addAttribute("user", new User());
        if(!userRepository.existsById(id)){
            return "redirect:/blog/usermain";
        }
        return "blog-userdetails";
    }

    @GetMapping("/blog/usermain/{id}/edit")
    public String blogEdit(@PathVariable("id") long id, Model model)
    {
        if(!userRepository.existsById(id)){
            return "redirect:/";
        }
        User res = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный id: "+id));
        model.addAttribute("user", res);

        return "blog-useredit";
    }

    @PostMapping("/blog/usermain/{id}/edit")
    public String blogPostUpdate(@PathVariable("id") long id, @ModelAttribute("user") @Validated User user, BindingResult bindingResult){
        user.setId(id);
        if(bindingResult.hasErrors()){

            return "blog-useredit";
        }
        userRepository.save(user);
        return "redirect:../";
    }

    @PostMapping("/blog/usermain/{id}/remove")
    public String blogPostRemove(@PathVariable("id") long id, Model model)
    {
        User post = userRepository.findById(id).orElseThrow();
        userRepository.delete(post);
        return "redirect:/";
    }

}
