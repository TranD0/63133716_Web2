package com.example.demo.Repositories;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.DatPhong;
import com.example.demo.Models.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
     @Query("SELECT h FROM HoaDon h WHERE h.madp = :datPhong")
    HoaDon findByDatPhong(@Param("datPhong") DatPhong datPhong);
    @Query("SELECT l FROM HoaDon l WHERE l.thoigiantao >= ?1 AND l.thoigiantao <= ?2")
List<HoaDon> searchByDateTimeRange(LocalDateTime startDate, LocalDateTime endDate);
}