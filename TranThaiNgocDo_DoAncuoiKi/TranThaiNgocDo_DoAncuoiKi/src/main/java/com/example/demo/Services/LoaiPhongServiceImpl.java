package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.LoaiPhong;
import com.example.demo.Repositories.LoaiPhongRepository;
@Service
public class LoaiPhongServiceImpl implements LoaiPhongService {

	@Autowired LoaiPhongRepository loaiPhongReposity;
	
	@Override
	public List<LoaiPhong> getAllLoaiPhong() {
		
		return loaiPhongReposity.findAll();
	}

	@Override
	public Optional<LoaiPhong> getLoaiPhongBYID(int MaLP) {
		// TODO Auto-generated method stub
		return loaiPhongReposity.findById(MaLP);
	}

	@Override
	public void addLoaiPhong(LoaiPhong loaiphong) {
		loaiPhongReposity.save(loaiphong);
		
	}

	@Override
	public void fixLoaiPhong(int MaLP) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLoaiPhong(int MaLP) {
		loaiPhongReposity.deleteById(MaLP);
		
	}

}
