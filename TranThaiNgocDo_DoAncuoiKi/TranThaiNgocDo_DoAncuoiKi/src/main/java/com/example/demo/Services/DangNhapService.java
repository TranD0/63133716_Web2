package com.example.demo.Services;
import org.springframework.stereotype.Service;

import com.example.demo.Models.NhanVien;
@Service
public interface DangNhapService {
    public NhanVien getNhanVienBYID(int manv);
    boolean KiemtraTK(String email, String password);
   
}
