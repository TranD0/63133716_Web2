package com.example.demo.controllers;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Services.NhanVienService;
import com.example.demo.Models.LoaiPhong;
import com.example.demo.Models.NhanVien;

@Controller
@RequestMapping("/Admin/NhanVien")
public class NhanVienController {
    @Autowired NhanVienService nhanVienService;
     @GetMapping("/Index")
	public String getAll(Model model) {
         List<NhanVien> dsNV = nhanVienService.getAllNhanVien();
	 	model.addAttribute("nhanvien", dsNV);
	 	return "NhanVien/Index";
	}
	@GetMapping("/Them")
   		public String hienTrangThem(Model model) {
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("pageTitle", "Thêm Nhân Viên");
        return "NhanVien/FormNV";
    	}
	@PostMapping("/Luu")
    public String themLoaiPhong(NhanVien nhanVien,RedirectAttributes ra ) {
        nhanVienService.addNhanVien(nhanVien);
        ra.addFlashAttribute("message","đã thêm nhân viên mới thành công!");
        return "redirect:/Admin/NhanVien/Index"; 
    }

}
