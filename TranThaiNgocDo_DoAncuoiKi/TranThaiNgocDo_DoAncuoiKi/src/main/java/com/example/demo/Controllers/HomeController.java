package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import ch.qos.logback.core.model.Model;

@Controller 
public class HomeController {
    @GetMapping("/login")
    public String showIndexPage() {
        return "login";
    }
    @RequestMapping("/logout")
	public String logout(Model model) {
		return "DangNhap";
	}
    @GetMapping()
    public String showAdminIndexPage() {
        return "AdminIndex";
    }

    
}


