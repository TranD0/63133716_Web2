package com.example.demo.controllers;

import java.io.IOException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Models.NhanVien;
import com.example.demo.Repositories.NhanVienRepository;
import com.example.demo.Services.NhanVienService;
import com.example.demo.Services.VaiTroService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller 
public class HomeController {
@Autowired VaiTroService vaiTroService;
@Autowired NhanVienService nhanVienService;
@Autowired NhanVienRepository nhanVienRepository;
@GetMapping({"/Admin/Index"})
public String showAdminIndexPage(Model model) {
    return "Index";
}

    @GetMapping("/login")
    public String login() {
        vaiTroService.createRoleIfNotFound("ADMIN");
        vaiTroService.createRoleIfNotFound("USER");
        nhanVienService.createRoleIfNotFound("cow@gmail.com");

        return "DangNhap"; 
    }
    @PostMapping("/login")
    public String loginSubmit() {
        // Xử lý đăng nhập ở đây
        return "redirect:/Index"; // Chuyển hướng sau khi đăng nhập thành công
    }
     @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    
    @GetMapping("/Admin/Sua/{maNV}")
    public String hienTrangSua(@PathVariable("maNV") int id,Model model,RedirectAttributes ra ) {
      
        NhanVien nhanVien =nhanVienService.getNhanVienBYID(id);
        model.addAttribute("nhanvien", nhanVien);
        model.addAttribute("pageTitle", "Sửa Nhân Viên(Mã: "+id+")");
        return "NhanVien/FormChange";
    }
    @PostMapping("/Admin/Luu")
    public String themNhanVien(NhanVien nhanVien, RedirectAttributes ra) throws IllegalStateException, IOException {
        // Retrieve the existing NhanVien entity from the database
        NhanVien existingNhanVien = nhanVienService.getNhanVienBYID(nhanVien.getMaNV());
    
        if (existingNhanVien != null) {
            // Update only the password
            String hashedPassword = BCrypt.hashpw(nhanVien.getMatKhau(), BCrypt.gensalt());
            existingNhanVien.setMatKhau(hashedPassword);
            
            // Save the updated entity
            nhanVienService.addNhanVien(existingNhanVien);
        }
    
        return "redirect:/Admin/Index";
    }
    
}


