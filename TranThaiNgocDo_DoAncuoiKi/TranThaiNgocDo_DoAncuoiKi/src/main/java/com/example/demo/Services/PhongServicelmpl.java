package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Phong;

import com.example.demo.Repositories.PhongRepository;

@Service
public class PhongServicelmpl implements PhongService {

	@Autowired PhongRepository PhongReposity;
	@Override
	public List<Phong> getAllPhong() {
		return PhongReposity.findAll();
	}

	@Override
	public Optional<Phong> getPhongBYID(int MaPhong) {
		return PhongReposity.findById(MaPhong);
	}

	@Override
	public void addPhong(Phong phong) {
		phong.setMaP(phong.getMaP());
		PhongReposity.save(phong);
		
	}

	@Override
	public void deletePhong(int MaPhong) {
		PhongReposity.deleteById(MaPhong);
		
	}

	@Override
	public Page<Phong> findAll(Integer soTrang) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public List<Phong> searchP(String tuKhoa) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'searchP'");
	}

	@Override
	public Page<Phong> searchP(String tuKhoa, Integer soTrang) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'searchP'");
	}

}
