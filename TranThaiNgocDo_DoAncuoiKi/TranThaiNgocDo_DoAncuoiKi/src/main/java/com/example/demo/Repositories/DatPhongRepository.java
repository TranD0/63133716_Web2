package com.example.demo.Repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.DatPhong;

@Repository
public interface DatPhongRepository extends JpaRepository<DatPhong, Integer> {
    @Query("SELECT TIMESTAMPDIFF(HOUR, d.ngayNhan, d.ngayTra) * l.giaTien " +
    "FROM DatPhong d JOIN d.malp l " +
    "WHERE d.madp = :madp")
BigDecimal tongTien(@Param("madp") int madp);
@Query("SELECT dp FROM DatPhong dp WHERE dp.tinhTrang = false")
List<DatPhong> findByTinhTrang();
}