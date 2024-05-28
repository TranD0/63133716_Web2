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
	@Column(name = "madv")
    private int maDV;

    @Column(name = "tendv", length = 50, nullable = false)
    private String tenDV;
	    
	@Column(name = "gia",precision = 10, scale = 2, nullable = false)
	 private BigDecimal gia;
	    
	@Column(name = "CoSan")
	private boolean CoSan;
    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "loaidonvi", nullable = false)
    private String loaiDonVi;

	    // Constructors
	    public DichVu() {
	        // Default constructor
	    }
	    
	    public DichVu(String tenDV, BigDecimal gia, boolean coSan, int soLuong, String loaiDonVi) {
	        this.tenDV = tenDV;
	        this.gia = gia;
	        this.CoSan = coSan;
	        this.soLuong = soLuong;
	        this.loaiDonVi = loaiDonVi;
	    }

		public int getMaDV() {
			return maDV;
		}

		public void setMaDV(int maDV) {
			this.maDV = maDV;
		}

		public String getTenDV() {
			return tenDV;
		}

		public void setTenDV(String tenDV) {
			this.tenDV = tenDV;
		}

		public BigDecimal getGia() {
			return gia;
		}

		public void setGia(BigDecimal gia) {
			this.gia = gia;
		}

		public boolean isCoSan() {
			return CoSan;
		}

		public void setCoSan(boolean coSan) {
			CoSan = coSan;
		}
		public int getSoLuong() {
			return soLuong;
		}

		public void setSoLuong(int soLuong) {
			this.soLuong = soLuong;
		}

		public String getLoaiDonVi() {
			return loaiDonVi;
		}

		public void setLoaiDonVi(String loaiDonVi) {
			this.loaiDonVi = loaiDonVi;
		}

		
	    // Getters and setters
	    
}
