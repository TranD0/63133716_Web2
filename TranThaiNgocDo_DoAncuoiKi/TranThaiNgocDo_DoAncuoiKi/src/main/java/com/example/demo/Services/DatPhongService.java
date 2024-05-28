package com.example.demo.Services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Models.DatPhong;

@Service
public interface DatPhongService {
    public List<DatPhong> getAll();
	public DatPhong getBYID(int madp);
	void add(DatPhong datPhong);
    void delete(int madp);
	Page<DatPhong> findAll(Integer soTrang);
	List<DatPhong> search(String tuKhoa);
	Page<DatPhong> search(String tuKhoa,Integer soTrang);
}
