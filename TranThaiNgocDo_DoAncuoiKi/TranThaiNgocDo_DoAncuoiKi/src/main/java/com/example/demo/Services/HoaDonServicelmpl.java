package com.example.demo.Services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.Models.HoaDon;
import com.example.demo.Repositories.HoaDonRepository;

@Service
public class HoaDonServicelmpl implements HoaDonService  {
    @Autowired HoaDonRepository donRepository;
    @Override
    public List<HoaDon> getAll() {
      return donRepository.findAll();
    }

    @Override
    public HoaDon getBYID(int Ma) {
          Optional<HoaDon> result=donRepository.findById(Ma);
		if(result.isPresent())
		return result.get();
		return null;
    }

    @Override
    public void add(HoaDon hoaDon) {
        hoaDon.setMaHD(hoaDon.getMaHD());
     donRepository.save(hoaDon);
    }

    @Override
    public void delete(int Ma) {
       donRepository.deleteById(Ma);
    }

    @Override
    public Page<HoaDon> findAll(Integer soTrang) {
        	Pageable pageable = PageRequest.of(soTrang - 1, 6);
       return this.donRepository.findAll(pageable);
    }

    @Override
    public List<HoaDon> search(LocalDateTime startDate, LocalDateTime endDate) {
        return donRepository.searchByDateTimeRange(startDate, endDate);	
    }

    @Override
    public Page<HoaDon> search(LocalDateTime startDate, LocalDateTime endDate, Integer soTrang) {
      List<HoaDon> list = this.search(startDate, endDate);
		Pageable pageable = PageRequest.of(soTrang - 1, 6);
		Integer batDau=(int) pageable.getOffset();
		Integer ketThuc=((int) ((pageable.getOffset()+pageable.getPageSize())>list.size() ? list.size()  : pageable.getOffset()+ pageable.getPageSize()));
		list=list.subList(batDau,ketThuc);
		return new PageImpl<HoaDon>(list,pageable,this.search(startDate, endDate).size());
    }

    @Override
    public BigDecimal TongTienHD(LocalDateTime startDate, LocalDateTime endDate) {
      return donRepository.TinhHoaDon(startDate, endDate);
    }


    
}
