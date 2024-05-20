package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Models.NhanVien;
import com.example.demo.Repositories.NhanVienRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
 @Autowired NhanVienRepository nhanVienRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       NhanVien nhanVien = nhanVienRepository.searchMaNV(username);
       if (nhanVien == null) {
        System.out.println("Không tìm thấy " + nhanVien);
        throw new UsernameNotFoundException("User " + nhanVien + " was not found in the database");
    }
    UserDetails userDetails = (UserDetails) new User(nhanVien.getEmail(),
    nhanVien.getMatKhau(), null);

return userDetails;
    }
    
}
