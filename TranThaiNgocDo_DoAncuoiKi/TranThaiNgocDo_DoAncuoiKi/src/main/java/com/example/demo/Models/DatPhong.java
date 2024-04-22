package com.example.demo.Models;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "datphong") 
public class DatPhong {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "MaDP")
	    private int MaDP;

	    @Column(name = "MaPhong")
	    private int MaPhong;

	    @Column(name = "NgayNhan")
	    private LocalDateTime NgayNhan;

	    @Column(name = "NgayTra")
	    private LocalDateTime NgayTra;

	    @Column(name = "TinhTrang")
	    private boolean TinhTrang;

	    @Column(name = "TenKH")
	    private String TenKH;

	    @Column(name = "Email")
	    private String Email;

	    @Column(name = "SDT")
	    private String SDT;

	    @Column(name = "TongTienDat",precision = 10, scale = 2)
	    private BigDecimal TongTienDat;

	    
	    // Constructors
	    public DatPhong() {}

	    public DatPhong(int MaDP, int MaPhong, LocalDateTime NgayNhan, LocalDateTime NgayTra, boolean TinhTrang, String TenKH, String Email, String SDT, BigDecimal TongTienDat) {
	        this.MaDP = MaDP;
	        this.MaPhong = MaPhong;
	        this.NgayNhan = NgayNhan;
	        this.NgayTra = NgayTra;
	        this.TinhTrang = TinhTrang;
	        this.TenKH = TenKH;
	        this.Email = Email;
	        this.SDT = SDT;
	        this.TongTienDat = TongTienDat;
	    }
	 //getters, and setters

		public int getMaDP() {
			return MaDP;
		}

		public void setMaDP(int maDP) {
			MaDP = maDP;
		}

		public int getMaPhong() {
			return MaPhong;
		}

		public void setMaPhong(int maPhong) {
			MaPhong = maPhong;
		}

		public LocalDateTime getNgayNhan() {
			return NgayNhan;
		}

		public void setNgayNhan(LocalDateTime ngayNhan) {
			NgayNhan = ngayNhan;
		}

		public LocalDateTime getNgayTra() {
			return NgayTra;
		}

		public void setNgayTra(LocalDateTime ngayTra) {
			NgayTra = ngayTra;
		}

		public boolean isTinhTrang() {
			return TinhTrang;
		}

		public void setTinhTrang(boolean tinhTrang) {
			TinhTrang = tinhTrang;
		}

		public String getTenKH() {
			return TenKH;
		}

		public void setTenKH(String tenKH) {
			TenKH = tenKH;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getSDT() {
			return SDT;
		}

		public void setSDT(String sDT) {
			SDT = sDT;
		}

		public BigDecimal getTongTienDat() {
			return TongTienDat;
		}

		public void setTongTienDat(BigDecimal tongTienDat) {
			TongTienDat = tongTienDat;
		}
	    
}
