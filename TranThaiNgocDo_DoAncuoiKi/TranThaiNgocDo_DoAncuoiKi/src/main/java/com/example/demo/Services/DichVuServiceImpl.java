package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Models.DichVu;
import com.example.demo.Repositories.DichVuRepository;

@Service
public class DichVuServiceImpl implements DichVuService{
    @Autowired DichVuRepository dichVuRepository;
    @Override
    public List<DichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }
    @Override
    public List<DichVu> getAllCon() {
       return dichVuRepository.dichVucon();
    }

    @Override
    public DichVu getDichVuBYID(int MaDV) {
       Optional<DichVu> result=dichVuRepository.findById(MaDV);
		if(result.isPresent())
		return result.get();
		return null;
    }

    @Override
    public void addDichVu(DichVu DichVu) {
        DichVu.setMaDV(DichVu.getMaDV());
		dichVuRepository.save(DichVu);
    }

    @Override
    public void deleteDichVu(int MaDV) {
     dichVuRepository.deleteById(MaDV);
    }

    @Override
    public Page<DichVu> findAll(Integer soTrang) {
     	Pageable pageable = PageRequest.of(soTrang - 1, 6);
       return this.dichVuRepository.findAll(pageable);
    }

    @Override
    public List<DichVu> search(String tuKhoa) {
        return this.dichVuRepository.search(tuKhoa);	
    }

    @Override
    public Page<DichVu> search(String tuKhoa, Integer soTrang) {
        	List<DichVu> list = this.search(tuKhoa);
        Pageable pageable = PageRequest.of(soTrang - 1, 6);
        Integer batDau=(int) pageable.getOffset();
        Integer ketThuc=((int) ((pageable.getOffset()+pageable.getPageSize())>list.size() ? list.size()  : pageable.getOffset()+ pageable.getPageSize()));
        list=list.subList(batDau,ketThuc);
        return new PageImpl<DichVu>(list,pageable,this.search(tuKhoa).size());
    }

    
    
}
