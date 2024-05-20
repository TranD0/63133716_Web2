package com.example.demo.Services;
import org.springframework.stereotype.Service;
import com.example.demo.Models.NhanVien;
@Service
public interface DangNhapService {
    public NhanVien getNhanVienBYEmail(String email);
   
}
