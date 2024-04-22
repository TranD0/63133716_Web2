package com.example.demo.Models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dichvu") 
public class DichVu {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "MaDV")
	    private int MaDV;
	    
	    @Column(name = "TenDV")
	    private String TenDV;
	    
	    @Column(name = "Gia",precision = 10, scale = 2)
	    private BigDecimal Gia;
	    
	    @Column(name = "CoSan")
	    private boolean CoSan;
	    
	    @Column(name = "MaNV")
	    private int MaNV;
	    
	    @Column(name = "SoLuong")
	    private int SoLuong;
	    
	    @Column(name = "LoaiDonVi")
	    private String LoaiDonVi;
	    
	    // Constructors
	    public DichVu() {
	        // Default constructor
	    }
	    
	    public DichVu(String tenDV, BigDecimal gia, boolean coSan, int maNV, int soLuong, String loaiDonVi) {
	        this.TenDV = tenDV;
	        this.Gia = gia;
	        this.CoSan = coSan;
	        this.MaNV = maNV;
	        this.SoLuong = soLuong;
	        this.LoaiDonVi = loaiDonVi;
	    }

		public int getMaDV() {
			return MaDV;
		}

		public void setMaDV(int maDV) {
			MaDV = maDV;
		}

		public String getTenDV() {
			return TenDV;
		}

		public void setTenDV(String tenDV) {
			TenDV = tenDV;
		}

		public BigDecimal getGia() {
			return Gia;
		}

		public void setGia(BigDecimal gia) {
			Gia = gia;
		}

		public boolean isCoSan() {
			return CoSan;
		}

		public void setCoSan(boolean coSan) {
			CoSan = coSan;
		}

		public int getMaNV() {
			return MaNV;
		}

		public void setMaNV(int maNV) {
			MaNV = maNV;
		}

		public int getSoLuong() {
			return SoLuong;
		}

		public void setSoLuong(int soLuong) {
			SoLuong = soLuong;
		}

		public String getLoaiDonVi() {
			return LoaiDonVi;
		}

		public void setLoaiDonVi(String loaiDonVi) {
			LoaiDonVi = loaiDonVi;
		}
	    
	    // Getters and setters
	    
}
