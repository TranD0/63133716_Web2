package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Models.DatPhong;
import com.example.demo.Repositories.DatPhongRepository;
@Service
public class DatPhongServicelmpl implements DatPhongService{
@Autowired DatPhongRepository datPhongRepository;
    @Override
    public List<DatPhong> getAll() {
        return datPhongRepository.findAll();
    }

    @Override
    public DatPhong getBYID(int madp) {
        Optional<DatPhong> result=datPhongRepository.findById(madp);
		if(result.isPresent())
		return result.get();
		return null;
    }

    @Override
    public void add(DatPhong datPhong) {
        datPhong.setMadp(datPhong.getMadp());
		datPhongRepository.save(datPhong);
    }

    @Override
    public void delete(int madp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<DatPhong> findAll(Integer soTrang) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<DatPhong> search(String tuKhoa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public Page<DatPhong> search(String tuKhoa, Integer soTrang) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
