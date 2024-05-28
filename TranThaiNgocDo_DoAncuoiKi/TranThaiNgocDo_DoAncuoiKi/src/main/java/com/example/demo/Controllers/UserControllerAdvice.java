package com.example.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.Models.NhanVien;
import com.example.demo.Repositories.NhanVienRepository;

@ControllerAdvice
public class UserControllerAdvice {

    private final NhanVienRepository nhanVienRepository;

    public UserControllerAdvice(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    @ModelAttribute("NVlogin")
    public NhanVien addNhanVienToModel(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            // Tìm kiếm thông tin nhân viên dựa trên email
            return nhanVienRepository.searchMaNV(email);
        }
        return null;
    }
}
