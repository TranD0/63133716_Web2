package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Models.DichVu;

public interface DichVuRepository extends JpaRepository<DichVu,Integer>{
     @Query("SELECT l FROM DichVu l WHERE l.tenDV LIKE %?1%")
    List<DichVu> search(String tuKhoa);
    @Query("SELECT dv FROM DichVu dv WHERE dv.soLuong > 0 AND dv.CoSan=true")
    List<DichVu> dichVucon();
} 
