package com.example.demo.Models;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "hoadon")
public class HoaDon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahd")
    private int maHD;

    @ManyToOne
    @JoinColumn(name = "madp",nullable = false)
    private DatPhong madp;
	    
	@Column(name = "tongtien",precision = 10, scale = 2, nullable = false)
	private BigDecimal tongTien;
	    
	@ManyToOne
	@JoinColumn(name = "manv", nullable = false)
	private NhanVien manv;
	    
	@Column(name = "thoigiantao", nullable = false)
	private LocalDateTime ThoiGianTao;
	    // Constructors
	    public HoaDon() {
	    }
	    
	    public HoaDon(DatPhong maDP,BigDecimal tongTien, NhanVien maNV, LocalDateTime thoiGianTao) {
			this.madp = maDP;
	        this.tongTien = tongTien;
	        this.manv= maNV;
	        this.ThoiGianTao = thoiGianTao;
	    }
	    //

		public int getMaHD() {
			return maHD;
		}

		public void setMaHD(int maHD) {
			this.maHD = maHD;
		}

		public DatPhong getMadp() {
			return madp;
		}

		public void setMadp(DatPhong madp) {
			this.madp = madp;
		}

		public BigDecimal getTongTien() {
			return tongTien;
		}

		public void setTongTien(BigDecimal tongTien) {
			this.tongTien = tongTien;
		}

		public NhanVien getManv() {
			return manv;
		}

		public void setManv(NhanVien manv) {
			this.manv = manv;
		}
		public LocalDateTime getThoiGianTao() {
			return ThoiGianTao;
		}

		public void setThoiGianTao(LocalDateTime thoiGianTao) {
			ThoiGianTao = thoiGianTao;
		}

		
}
