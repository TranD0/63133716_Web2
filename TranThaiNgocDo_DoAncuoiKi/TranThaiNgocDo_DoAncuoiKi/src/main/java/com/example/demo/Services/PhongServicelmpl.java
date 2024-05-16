package com.example.demo.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Phong getPhongBYID(int MaP) {
		Optional<Phong> result=PhongReposity.findById(MaP);
		if(result.isPresent())
		return result.get();
		return null;
	}

	@Override
	public void addPhong(Phong phong) {
		phong.setMaP(phong.getMaP());
		PhongReposity.save(phong);
		
	}

	@Override
	public void deletePhong(int MaP) {
		PhongReposity.deleteById(MaP);
		
	}

	@Override
	public Page<Phong> findAll(Integer soTrang) {
		Pageable pageable = PageRequest.of(soTrang - 1, 2);
       return this.PhongReposity.findAll(pageable);
	}
	
	@Override
	public List<Phong> searchP(String tuKhoa) {
		return this.PhongReposity.searchP(tuKhoa);	
	}

	@Override
	public Page<Phong> searchP(String tuKhoa, Integer soTrang) {

		List<Phong> list = this.searchP(tuKhoa);
		Pageable pageable = PageRequest.of(soTrang - 1, 2);
		Integer batDau=(int) pageable.getOffset();
		Integer ketThuc=((int) ((pageable.getOffset()+pageable.getPageSize())>list.size() ? list.size()  : pageable.getOffset()+ pageable.getPageSize()));
		list=list.subList(batDau,ketThuc);
		return new PageImpl<Phong>(list,pageable,this.searchP(tuKhoa).size());
	}

}
