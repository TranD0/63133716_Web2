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
	@Column(name = "MALP")    // tên cột, trong bảng , phải viết giống 100%
	private int MaLP;
	
	@Column(name="TenLP" )
	private String TenLP;
	
	@Column(name="Giatien", precision = 10, scale = 2 )
	private BigDecimal Giatien;
	
	@Column(name = "succhua") 
	private int Succhua;
	
	@Column(name="Mota" )
	private String Mota;
	
	//
	public LoaiPhong(){}
	public LoaiPhong(int MaLP,String TenLP,BigDecimal Giatien,int Succhua, String Mota){
		this.MaLP=MaLP;
		this.TenLP=TenLP;
		this.Giatien=Giatien;
		this.Succhua=Succhua;
		this.Mota=Mota;
	}
	//get,set
	public int getMaLP() {
		return MaLP;
	}
	public void setMaLP(int maLP) {
		this.MaLP = maLP;
	}
	public String getTenLP() {
		return TenLP;
	}
	public void setTenLP(String tenLP) {
		TenLP = tenLP;
	}
	public BigDecimal getGiatien() {
		return Giatien;
	}
	public void setGiatien(BigDecimal Giatien) {
		this.Giatien = Giatien;
	}
	public int getSucchua() {
		return Succhua;
	}
	public void setSucchua(int succhua) {
		Succhua = succhua;
	}
	public String getMota() {
		return Mota;
	}
	public void setMota(String mota) {
		Mota = mota;
	}

}
