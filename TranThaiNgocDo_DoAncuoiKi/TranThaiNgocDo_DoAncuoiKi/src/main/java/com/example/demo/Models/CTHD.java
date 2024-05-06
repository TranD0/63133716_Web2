package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "cthd")
public class CTHD {
  
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "macthd")
    private int macthd;
    
    @ManyToOne
    @JoinColumn(name = "mahd", nullable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "madv", nullable = false)
    private DichVu dichVu;

    @Column(name = "soluong")
    private int soLuong;

  


    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getMacthd() {
        return macthd;
    }

    public void setMacthd(int macthd) {
        this.macthd = macthd;
    }

   
    
}
