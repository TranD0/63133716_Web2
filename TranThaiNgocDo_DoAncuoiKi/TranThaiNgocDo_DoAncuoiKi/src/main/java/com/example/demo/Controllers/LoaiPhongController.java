package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.LoaiPhong;
import com.example.demo.Services.LoaiPhongService;

@RestController
public class LoaiPhongController {
	@Autowired LoaiPhongService loaiPhongService;
	@GetMapping("/dsLoaiPhong")
	public List<LoaiPhong> getAllLoaiPhong()
	{
		return loaiPhongService.getAllLoaiPhong();
	}
}
