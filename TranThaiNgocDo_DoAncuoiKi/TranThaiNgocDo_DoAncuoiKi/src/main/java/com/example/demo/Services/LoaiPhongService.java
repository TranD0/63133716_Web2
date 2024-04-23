package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Models.LoaiPhong;

@Service
public interface LoaiPhongService {
	public List<LoaiPhong> getAllLoaiPhong();
	public Optional<LoaiPhong> getLoaiPhongBYID(int MaLP);
	void addLoaiPhong(LoaiPhong loaiphong);
	void fixLoaiPhong(int MaLP);
    void deleteLoaiPhong(int MaLP);
}
