package com.example.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Models.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro,Integer>{
     @Query("SELECT l FROM VaiTro l WHERE l.tenVT LIKE %?1%")
    List<VaiTro> search(String tuKhoa);
}
