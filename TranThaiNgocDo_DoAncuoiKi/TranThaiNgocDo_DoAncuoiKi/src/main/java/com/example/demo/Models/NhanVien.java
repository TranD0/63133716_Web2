package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhanvien") 
public class NhanVien {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNV")
    private int MaNV;
    
    @Column(name = "Ho")
    private String Ho;
    
    @Column(name = "Ten")
    private String Ten;
    
    @Column(name = "SDT")
    private String SDT;
    
    @Column(name = "Email")
    private String Email;
    
    @Column(name = "GT")
    private boolean GT; // Giới tính, có thể sử dụng String hoặc enum
    
    @Column(name = "MatKhau")
    private String MatKhau;
    //
    public NhanVien() {
    }
    
    public NhanVien(String ho, String ten, String sdt, String email, boolean gt, String matKhau) {
        this.Ho = ho;
        this.Ten = ten;
        this.SDT = sdt;
        this.Email = email;
        this.GT = gt;
        this.MatKhau = matKhau;
    }
    //

	public int getMaNV() {
		return MaNV;
	}

	public void setMaNV(int maNV) {
		MaNV = maNV;
	}

	public String getHo() {
		return Ho;
	}

	public void setHo(String ho) {
		Ho = ho;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isGT() {
		return GT;
	}

	public void setGT(boolean gT) {
		GT = gT;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
    
}
