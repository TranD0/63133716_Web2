package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Models.NhanVien;
public interface NhanVienRepository extends JpaRepository<NhanVien,Integer>  {
     @Query("SELECT l FROM NhanVien l WHERE CONCAT(l.ho, ' ', l.ten) LIKE %?1%")
    List<NhanVien> searchNV(String tuKhoa);
  
    @Query("SELECT l FROM NhanVien l WHERE l.email LIKE %?1%")
    NhanVien searchMaNV(String tuKhoa);
      

}
