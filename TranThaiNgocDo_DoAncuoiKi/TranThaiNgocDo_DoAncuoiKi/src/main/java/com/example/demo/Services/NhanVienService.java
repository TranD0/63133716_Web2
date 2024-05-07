package com.example.demo.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.demo.Models.NhanVien;
@Service
public interface NhanVienService {
public List<NhanVien> getAllNhanVien();
	public NhanVien getNhanVienBYID(int manv);
	void addNhanVien(NhanVien nhanVien);
    void deleteNhanVien(int manv);
	Page<NhanVien> findAll(Integer soTrang);
	List<NhanVien> searchNV(String tuKhoa);
	Page<NhanVien> searchNV(String tuKhoa,Integer soTrang);
}
