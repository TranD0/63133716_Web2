package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.CTHD;

@Repository
public interface CTHDRepository extends JpaRepository<CTHD, Integer> {
        @Query("SELECT c FROM CTHD c WHERE c.hoaDon.maHD = :maHD")
    List<CTHD> findByMaHD(@Param("maHD") int maHD);
}
