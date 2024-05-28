package com.example.demo.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Models.HoaDon;
@Service
public interface HoaDonService {
    	public List<HoaDon> getAll();
	public HoaDon getBYID(int Ma);
	void add(HoaDon hoaDon);
    void delete(int Ma);
    Page<HoaDon> findAll(Integer soTrang);
	List<HoaDon> search(LocalDateTime startDate, LocalDateTime endDate);
	Page<HoaDon> search(LocalDateTime startDate, LocalDateTime endDate,Integer soTrang);
}
