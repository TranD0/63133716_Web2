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
	
	//
	public Phong() {}
	public Phong(int MaPhong, String SoPhong, LoaiPhong MaLP, boolean TinhTrang) {
		this.maP=MaPhong;
		this.soP=SoPhong;
		this.malp=MaLP;
		this.tinhTrang=TinhTrang;
	}
	//
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

	
	
}
