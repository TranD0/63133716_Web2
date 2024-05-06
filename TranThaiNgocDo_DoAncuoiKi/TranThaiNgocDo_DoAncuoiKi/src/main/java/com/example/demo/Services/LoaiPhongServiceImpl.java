package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
// import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public LoaiPhong getLoaiPhongBYID(int MaLP) {
		Optional<LoaiPhong> result=loaiPhongReposity.findById(MaLP);
		if(result.isPresent())
		return result.get();
		return null;
	}

	@Override
	public void addLoaiPhong(LoaiPhong loaiphong) {
		
		loaiphong.setMaLP(loaiphong.getMaLP());
		loaiPhongReposity.save(loaiphong);
		
	}
	@Override
	public void deleteLoaiPhong(int MaLP) {
		loaiPhongReposity.deleteById(MaLP);
		
	}

	@Override
	public Page<LoaiPhong> findAll(Integer soTrang) {
		Pageable pageable = PageRequest.of(soTrang - 1, 2);
       return this.loaiPhongReposity.findAll(pageable);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Page<LoaiPhong> searchLP(String tuKhoa, Integer soTrang) {
		@SuppressWarnings("rawtypes")
		List list = this.searchLP(tuKhoa);
		Pageable pageable = PageRequest.of(soTrang - 1, 2);
		Integer batDau=(int) pageable.getOffset();
		Integer ketThuc=((int) ((pageable.getOffset()+pageable.getPageSize())>list.size() ? list.size()  : pageable.getOffset()+ pageable.getPageSize()));
		list=list.subList(batDau,ketThuc);
		return new PageImpl<LoaiPhong>(list,pageable,this.searchLP(tuKhoa).size());
	
	}

	@Override
	public List<LoaiPhong> searchLP(String tuKhoa) {
	return this.loaiPhongReposity.searchLP(tuKhoa);	

	}

}
