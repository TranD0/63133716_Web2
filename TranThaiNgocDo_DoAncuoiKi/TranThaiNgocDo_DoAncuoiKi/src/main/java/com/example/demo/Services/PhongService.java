package com.example.demo.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.demo.Models.Phong;

@Service
public interface PhongService {
	public List<Phong> getAllPhong();
	public Optional<Phong> getPhongBYID(int maP);
	 void addPhong(Phong phong);
    void deletePhong(int maP);
	Page<Phong> findAll(Integer soTrang);
	List<Phong> searchP(String tuKhoa);
	Page<Phong> searchP(String tuKhoa,Integer soTrang);
}
