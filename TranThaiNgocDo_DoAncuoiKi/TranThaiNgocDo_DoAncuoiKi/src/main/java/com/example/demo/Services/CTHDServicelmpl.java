package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Models.CTHD;
import com.example.demo.Repositories.CTHDRepository;
@Service
public class CTHDServicelmpl implements CTHDService{
    @Autowired CTHDRepository cthdRepository;
    @Override
    public List<CTHD> getAll() {
       return cthdRepository.findAll();
    }

    @Override
    public CTHD getBYID(int ma) {
        Optional<CTHD> result=cthdRepository.findById(ma);
		if(result.isPresent())
		return result.get();
		return null;
    }

    @Override
    public void add(CTHD cthd) {
        cthd.setMacthd(cthd.getMacthd());
		cthdRepository.save(cthd);
    }

    @Override
    public void delete(int ma) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<CTHD> findAll(Integer soTrang) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<CTHD> search(String tuKhoa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public Page<CTHD> search(String tuKhoa, Integer soTrang) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public List<CTHD> findbymahd(int ma) {
        return cthdRepository.findByMaHD(ma);
    }
    
}
