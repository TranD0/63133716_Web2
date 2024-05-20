package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller 
public class HomeController {

    @GetMapping("/Admin/AdminIndex")
    public String showAdminIndexPage() {
        return "AdminIndex";
    }
    @GetMapping("/loginn")
    public String loginPage(Model model) {

        return "DangNhap";
    }

    
}


