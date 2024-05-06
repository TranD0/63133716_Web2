package com.example.demo.Services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.demo.Models.LoaiPhong;

@Service
public interface LoaiPhongService {
	public List<LoaiPhong> getAllLoaiPhong();
	public LoaiPhong getLoaiPhongBYID(int MaLP);
	void addLoaiPhong(LoaiPhong loaiphong);
    void deleteLoaiPhong(int MaLP);
	Page<LoaiPhong> findAll(Integer soTrang);
	List<LoaiPhong> searchLP(String tuKhoa);
	Page<LoaiPhong> searchLP(String tuKhoa,Integer soTrang);

}
