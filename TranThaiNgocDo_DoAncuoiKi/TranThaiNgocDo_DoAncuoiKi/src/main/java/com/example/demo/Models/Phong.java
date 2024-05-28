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
@Table(name = "phong")
public class Phong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "map")
    private int maP;

    @Column(name = "sop", length = 50, nullable = false)
    private String soP;
	
	@ManyToOne
    @JoinColumn(name = "malp", nullable = false)
    private LoaiPhong malp;

    @Column(name = "tinhtrang")
    private boolean tinhTrang;
	
	@ManyToOne
    @JoinColumn(name = "madp")
    private DatPhong madp;
	

	public Phong() {
	}

	public Phong(int maP, String soP, LoaiPhong malp, boolean tinhTrang, DatPhong madp) {
		this.maP = maP;
		this.soP = soP;
		this.malp = malp;
		this.tinhTrang = tinhTrang;
		this.madp = madp;
	}

	public int getMaP() {
		return maP;
	}

	public void setMaP(int maP) {
		this.maP = maP;
	}

	public String getSoP() {
		return soP;
	}

	public void setSoP(String soP) {
		this.soP = soP;
	}

	public LoaiPhong getMalp() {
		return malp;
	}

	public void setMalp(LoaiPhong malp) {
		this.malp = malp;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public DatPhong getMadp() {
		return madp;
	}

	public void setMadp(DatPhong madp) {
		this.madp = madp;
	}
		
	
}
