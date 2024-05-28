package com.example.demo.Models;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loaiphong")
public class LoaiPhong {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "malp")
	private int malp;

	@Column(name = "tenlp", length = 50, nullable = false)
	private String tenlp;

	@Column(name = "giatien", precision = 10, scale = 2, nullable = false)
	private BigDecimal giaTien;

	@Column(name = "succhua", nullable = false)
	private Integer sucChua;

	@Column(name = "mota", length = 100, nullable = false)
	private String moTa;
	//
	public LoaiPhong() {
	}

	public LoaiPhong(int malp, String tenlp, BigDecimal giaTien, int sucChua, String moTa) {
		this.malp =malp;
		this.tenlp = tenlp;
		this.giaTien = giaTien;
		this.sucChua = sucChua;
		this.moTa = moTa;
	}
	// get,set

	public int getMaLP() {
		return malp;
	}

	public void setMaLP(int maLP) {
		this.malp = maLP;
	}

	public String getTenLP() {
		return tenlp;
	}

	public void setTenLP(String tenLP) {
		this.tenlp = tenLP;
	}

	public BigDecimal getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(BigDecimal giaTien) {
		this.giaTien = giaTien;
	}

	public Integer getSucChua() {
		return sucChua;
	}

	public void setSucChua(Integer sucChua) {
		this.sucChua = sucChua;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return  tenlp ;
	}

}
