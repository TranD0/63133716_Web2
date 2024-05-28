package com.example.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Models.Phong;
public interface PhongRepository extends JpaRepository<Phong,Integer> {
 @Query("SELECT l FROM Phong l WHERE l.malp.tenlp LIKE %?1%")
    List<Phong> searchP(String tuKhoa);
}
