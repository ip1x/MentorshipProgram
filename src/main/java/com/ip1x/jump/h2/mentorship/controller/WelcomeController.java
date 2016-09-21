package com.ip1x.jump.h2.mentorship.controller;

import com.ip1x.jump.h2.mentorship.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping
    public String printWelcome(ModelMap model){
        model.addAttribute("message", "Hello!");
        return "hello";
    }
}
