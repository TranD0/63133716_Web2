package com.example.demo.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoadon") 
public class HoaDon {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "MaHD")
	    private int MaHD;
	    
	    @Column(name = "MaDP")
	    private int MaDP;
	    
	    @Column(name = "TongTien",precision = 10, scale = 2)
	    private BigDecimal TongTien;
	    
	    @Column(name = "MaNV")
	    private int MaNV;
	    
	    @Column(name = "CachTra")
	    private String CachTra;
	    
	    @Column(name = "ThoiGianTao")
	    private LocalDateTime ThoiGianTao;
	    
	    // Constructors
	    public HoaDon() {
	    }
	    
	    public HoaDon(int maDP,BigDecimal tongTien, int maNV, String cachTra, LocalDateTime thoiGianTao) {
	        this.MaDP = maDP;
	        this.TongTien = tongTien;
	        this.MaNV = maNV;
	        this.CachTra = cachTra;
	        this.ThoiGianTao = thoiGianTao;
	    }
	    //

		public int getMaHD() {
			return MaHD;
		}

		public void setMaHD(int maHD) {
			MaHD = maHD;
		}

		public int getMaDP() {
			return MaDP;
		}

		public void setMaDP(int maDP) {
			MaDP = maDP;
		}

		public BigDecimal getTongTien() {
			return TongTien;
		}

		public void setTongTien(BigDecimal tongTien) {
			TongTien = tongTien;
		}

		public int getMaNV() {
			return MaNV;
		}

		public void setMaNV(int maNV) {
			MaNV = maNV;
		}

		public String getCachTra() {
			return CachTra;
		}

		public void setCachTra(String cachTra) {
			CachTra = cachTra;
		}

		public LocalDateTime getThoiGianTao() {
			return ThoiGianTao;
		}

		public void setThoiGianTao(LocalDateTime thoiGianTao) {
			ThoiGianTao = thoiGianTao;
		}
	    
}
