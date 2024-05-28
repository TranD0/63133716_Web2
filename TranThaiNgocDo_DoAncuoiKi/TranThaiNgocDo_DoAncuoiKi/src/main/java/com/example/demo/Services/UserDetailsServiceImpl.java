package com.example.demo.Services;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.Models.NhanVien;
import com.example.demo.Repositories.NhanVienRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NhanVien nhanVien = nhanVienRepository.searchMaNV(username);
        if (nhanVien == null) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng với tên đăng nhập: " + username);
        }
     
      
        return new User(nhanVien.getEmail(),nhanVien.getMatKhau(), getAuthorities(nhanVien));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(NhanVien nhanVien) {
        String roleName = nhanVien.getMavt().getTenVT();
        return Collections.singletonList(new SimpleGrantedAuthority(roleName));
    }
}
