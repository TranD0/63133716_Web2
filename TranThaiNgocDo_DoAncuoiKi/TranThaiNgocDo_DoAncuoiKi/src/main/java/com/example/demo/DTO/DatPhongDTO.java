package com.example.demo.DTO;

import java.math.BigDecimal;

import com.example.demo.Models.DatPhong;

public class DatPhongDTO {
    private DatPhong datPhong;
    private BigDecimal tongTien;

    public DatPhongDTO(DatPhong datPhong, BigDecimal tongTien) {
        this.datPhong = datPhong;
        this.tongTien = tongTien;
    }

    // getters and setters
    public DatPhong getDatPhong() {
        return datPhong;
    }

    public void setDatPhong(DatPhong datPhong) {
        this.datPhong = datPhong;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }
}
