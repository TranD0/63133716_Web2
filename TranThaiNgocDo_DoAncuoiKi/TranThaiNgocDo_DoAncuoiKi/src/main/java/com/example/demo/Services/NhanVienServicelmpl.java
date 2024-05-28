package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.Models.NhanVien;
import com.example.demo.Repositories.NhanVienRepository;
@Service
public class NhanVienServicelmpl implements NhanVienService{
    @Autowired NhanVienRepository nhanVienRepository;
    @Autowired VaiTroService vaiTroService;
    @Override
    public List<NhanVien> getAllNhanVien() {
       return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getNhanVienBYID(int manv) {
       Optional<NhanVien> result=nhanVienRepository.findById(manv);
		if(result.isPresent())
		return result.get();
		return null;
    }

    @Override
    public void addNhanVien(NhanVien nhanVien) {
        nhanVien.setMaNV(nhanVien.getMaNV());
		nhanVienRepository.save(nhanVien);
    }

    @Override
    public void deleteNhanVien(int manv) {
        nhanVienRepository.deleteById(manv);
    }

    @Override
    public Page<NhanVien> findAll(Integer soTrang) {
     	Pageable pageable = PageRequest.of(soTrang - 1, 2);
       return this.nhanVienRepository.findAll(pageable);
    }

    @Override
    public List<NhanVien> searchNV(String tuKhoa) {
        return this.nhanVienRepository.searchNV(tuKhoa);
    }
    @Override
    public Page<NhanVien> searchNV(String tuKhoa, Integer soTrang) {
		List<NhanVien> list = this.searchNV(tuKhoa);
		Pageable pageable = PageRequest.of(soTrang - 1, 2);
		Integer batDau=(int) pageable.getOffset();
		Integer ketThuc=((int) ((pageable.getOffset()+pageable.getPageSize())>list.size() ? list.size()  : pageable.getOffset()+ pageable.getPageSize()));
		list=list.subList(batDau,ketThuc);
		return new PageImpl<NhanVien>(list,pageable,this.searchNV(tuKhoa).size());
    }

    @Override
    public boolean emailExists(String email) {
      NhanVien nhanvien =nhanVienRepository.searchMaNV(email);
      if (nhanvien == null) 
        return false;
       if(nhanvien.getEmail().equals(email))
           return true;
      return false;
    }

    @Override
    public void createRoleIfNotFound(String tuKhoa) {
     NhanVien nhanViens = nhanVienRepository.searchMaNV(tuKhoa);
      if (nhanViens == null) {
      { String hashedPassword = BCrypt.hashpw("123", BCrypt.gensalt());
        NhanVien nVien = new NhanVien();
        nVien.setHo(tuKhoa);
        nVien.setTen(tuKhoa);
        nVien.setEmail(tuKhoa);
        nVien.setSdt("123456789");
        nVien.setAnhNV("cow.jpg");
        nVien.setMatKhau(hashedPassword);
        nVien.setMavt(vaiTroService.getVaiTroBYID(1));
    
        
        nhanVienRepository.save(nVien);
      }
    }
  }
}
