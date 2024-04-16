package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	 @GetMapping("/Home")
	    public String showIndexPage() {
	        return "Index";
	    }
}
