package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.example.demo.Models.LoaiPhong;
import com.example.demo.Services.LoaiPhongService;
@Controller
@RequestMapping("/LoaiPhong")
public class LoaiPhongController {
	@Autowired LoaiPhongService loaiPhongService;
	
//	public List<LoaiPhong> getAllLoaiPhong()
//	{
//		return loaiPhongService.getAllLoaiPhong();
//	}
	@GetMapping("")
	public String getAll(Model model) {
		List<LoaiPhong> dsLP = loaiPhongService.getAllLoaiPhong();		
		model.addAttribute("dsLoaiPhong", dsLP);
		return "LoaiPhong";
	}
}
