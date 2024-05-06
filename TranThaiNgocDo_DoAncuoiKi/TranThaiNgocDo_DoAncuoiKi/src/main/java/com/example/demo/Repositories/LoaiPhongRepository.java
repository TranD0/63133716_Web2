package com.example.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Models.LoaiPhong;
public interface LoaiPhongRepository extends JpaRepository<LoaiPhong,Integer> {
    @Query("SELECT l FROM LoaiPhong l WHERE l.tenlp LIKE %?1%")
    List<LoaiPhong> searchLP(String tuKhoa);
}
