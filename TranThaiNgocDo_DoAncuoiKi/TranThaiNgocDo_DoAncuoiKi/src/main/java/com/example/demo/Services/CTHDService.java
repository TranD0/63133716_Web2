package com.example.demo.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Models.CTHD;
@Service
public interface CTHDService {
     public List<CTHD> getAll();
	 public List<CTHD> findbymahd(int ma);
	public CTHD getBYID(int ma);
	void add(CTHD cthd);
    void delete(int ma);
	Page<CTHD> findAll(Integer soTrang);
	List<CTHD> search(String tuKhoa);
	Page<CTHD> search(String tuKhoa,Integer soTrang);
}
