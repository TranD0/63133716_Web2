package com.example.demo.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.Models.VaiTro;
@Service
public interface VaiTroService {
    public List<VaiTro> getAllVaiTro();
	public VaiTro getVaiTroBYID(int ma);
	//  void addVaiTro(VaiTro vaiTro);
    // void deleteVaiTro(int ma);
	// Page<VaiTro> findAll(Integer soTrang);
	// List<VaiTro> search(String tuKhoa);
	// Page<VaiTro> search(String tuKhoa,Integer soTrang);
	public void createRoleIfNotFound(String tuKhoa);
}
