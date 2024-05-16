package com.gr.clientservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("login")
    public String login(){
        return  "login";
    }
    @GetMapping("home")
    public String home(){
        return  "home";
    }
    @GetMapping("assign/{teamId}")
    public String assign(){
        return  "assign";
    }

}
