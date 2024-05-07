package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.Models.NhanVien;
import com.example.demo.Repositories.NhanVienRepository;
@Service
public class NhanVienServicelmpl implements NhanVienService{
    @Autowired NhanVienRepository nhanVienRepository;
    @Override
    public List<NhanVien> getAllNhanVien() {
       return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getNhanVienBYID(int manv) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNhanVienBYID'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchNV'");
    }

    @Override
    public Page<NhanVien> searchNV(String tuKhoa, Integer soTrang) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchNV'");
    }

}
