package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class HomeController {
    @GetMapping("/")
    public String showIndexPage() {
        return "DangNhap";
    }
    @GetMapping("/Admin/Home")
    public String showAdminIndexPage() {
        return "AdminIndex";
    }
}
