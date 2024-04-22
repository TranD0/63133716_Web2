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
	@Column(name = "MaPhong")    
	private int MaPhong;
	
	@Column(name="SoPhong" )
	private String SoPhong;
	
	@ManyToOne
    @JoinColumn(name = "MaLP")
    private LoaiPhong MaLP;
	
	@Column(name = "TinhTrang") 
	private boolean TinhTrang;
	
	//
	public Phong() {}
	public Phong(int MaPhong, String SoPhong, LoaiPhong MaLP, boolean TinhTrang) {
		this.MaPhong=MaPhong;
		this.SoPhong=SoPhong;
		this.MaLP=MaLP;
		this.TinhTrang=TinhTrang;
	}
	//

	public int getMaPhong() {
		return MaPhong;
	}

	public void setMaPhong(int maPhong) {
		MaPhong = maPhong;
	}

	public String getSoPhong() {
		return SoPhong;
	}

	public void setSoPhong(String soPhong) {
		SoPhong = soPhong;
	}
	public boolean isTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		TinhTrang = tinhTrang;
	}
	 public LoaiPhong getLoaiPhong() {
	        return MaLP;
	    }

	    public void setLoaiPhong(LoaiPhong MaLP) {
	        this.MaLP = MaLP;
	    }
	
}
