package com.example.demo.Services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Models.DichVu;


@Service
public interface DichVuService {
    public List<DichVu> getAllDichVu();
	public DichVu getDichVuBYID(int MaDV);
	void addDichVu(DichVu DichVu);
    void deleteDichVu(int MaDV);
	Page<DichVu> findAll(Integer soTrang);
	List<DichVu> search(String tuKhoa);
	Page<DichVu> search(String tuKhoa,Integer soTrang);
}
