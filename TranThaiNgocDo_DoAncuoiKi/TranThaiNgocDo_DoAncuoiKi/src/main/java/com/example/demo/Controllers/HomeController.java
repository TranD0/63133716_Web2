package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller 
public class HomeController {
    @GetMapping("/")
    public String showIndexPage() {
        return "DangNhap";
    }
    @RequestMapping("/logout")
	public String logout(Model model) {
		return "DangNhap";
	}
    @GetMapping("/Admin/Home")
    public String showAdminIndexPage() {
        return "AdminIndex";
    }
}
