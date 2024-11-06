package com.example.sqc9ex1.controllers;

import com.example.sqc9ex1.processors.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String login(){
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model){
        boolean loginIn = false;
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        if(loginProcessor.login()){
            model.addAttribute("message", "You are already logged in!");
            return "redirect:/main";
        }else{
            model.addAttribute("message", "Login failed!");
            return "login.html";
        }
    }

}
