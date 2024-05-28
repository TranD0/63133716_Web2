package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
       datPhongRepository.deleteById(madp);
    }

    @Override
    public Page<DatPhong> findAll(Integer soTrang) {
       	Pageable pageable = PageRequest.of(soTrang - 1, 6);
       return this.datPhongRepository.findAll(pageable);
    }

    @Override
    public List<DatPhong> search(String tuKhoa) {
        return this.datPhongRepository.search(tuKhoa);	
    }

    @Override
    public Page<DatPhong> search(String tuKhoa, Integer soTrang) {
       	List<DatPhong> list = this.search(tuKhoa);
        Pageable pageable = PageRequest.of(soTrang - 1, 6);
        Integer batDau=(int) pageable.getOffset();
        Integer ketThuc=((int) ((pageable.getOffset()+pageable.getPageSize())>list.size() ? list.size()  : pageable.getOffset()+ pageable.getPageSize()));
        list=list.subList(batDau,ketThuc);
        return new PageImpl<DatPhong>(list,pageable,this.search(tuKhoa).size());
    }
    
}
