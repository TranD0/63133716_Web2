package com.example.demo.controllers;


import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.demo.Models.HoaDon;
import com.example.demo.Services.HoaDonService;

@Controller 
@RequestMapping("/Admin/HoaDon")
public class HoaDonController {
    @Autowired HoaDonService donService;
  
    @GetMapping("/Index")
    public String getAll(Model model, @Param("startDate") LocalDateTime start, @Param("endDate") LocalDateTime end, @RequestParam(name = "soTrang", defaultValue = "1") Integer soTrang) {
        Page<HoaDon> ds;
        
        if (start != null && end != null) {
            ds = this.donService.search(start, end, soTrang);
            model.addAttribute("tuKhoa1", start);
            model.addAttribute("tuKhoa2", end);
        } else {
            ds = this.donService.findAll(soTrang);
        }
        
        model.addAttribute("TongSoTrang", ds.getTotalPages());	
        model.addAttribute("TrangHienTai", soTrang);
        model.addAttribute("HoaDon", ds);
        
        return "HoaDon/Index";
    }
    
  
}