package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.VaiTro;
import com.example.demo.Repositories.VaiTroRepository;
@Service
public class VaiTroServicelmpl implements VaiTroService {
    
    @Autowired VaiTroRepository vaiTroRepository;
    @Override
    public List<VaiTro> getAllVaiTro() {
        return vaiTroRepository.findAll();
    }

    @Override
    public VaiTro getVaiTroBYID(int ma) {
      Optional<VaiTro> result= vaiTroRepository.findById(ma);
		if(result.isPresent())
		return result.get();
		return null;
    }

    // @Override
    // public void addVaiTro(VaiTro vaiTro) {
    //     vaiTro.setMaVT(vaiTro.getMaVT());
	// 	vaiTroRepository.save(vaiTro);
    // }

    // @Override
    // public void deleteVaiTro(int ma) {
    //     vaiTroRepository.deleteById(ma);
    // }

    // @Override
    // public Page<VaiTro> findAll(Integer soTrang) {
    //     	Pageable pageable = PageRequest.of(soTrang - 1, 2);
    //    return this.vaiTroRepository.findAll(pageable);
    // }

    // @Override
    // public List<VaiTro> search(String tuKhoa) {
    //     return vaiTroRepository.search(tuKhoa);	
    // }

    // @Override
    // public Page<VaiTro> search(String tuKhoa, Integer soTrang) {
    //     List<VaiTro> list = this.search(tuKhoa);
	// 	Pageable pageable = PageRequest.of(soTrang - 1, 2);
	// 	Integer batDau=(int) pageable.getOffset();
	// 	Integer ketThuc=((int) ((pageable.getOffset()+pageable.getPageSize())>list.size() ? list.size()  : pageable.getOffset()+ pageable.getPageSize()));
	// 	list=list.subList(batDau,ketThuc);
	// 	return new PageImpl<VaiTro>(list,pageable,this.search(tuKhoa).size());
    // }

    @Override
    public void createRoleIfNotFound(String tuKhoa) {
      if(vaiTroRepository.search(tuKhoa).isEmpty())
      {
        VaiTro vaiTro = new VaiTro();
        vaiTro.setTenVT(tuKhoa);
        vaiTroRepository.save(vaiTro);
      }
      
            
    }
    
}
