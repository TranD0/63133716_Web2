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
@Table(name = "nhanvien") 
public class NhanVien {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manv")
    private int maNV;

    @Column(name = "ho", length = 50, nullable = false)
    private String ho;

    @Column(name = "ten", length = 50, nullable = false)
    private String ten;

    @Column(name = "sdt", length = 50, nullable = false)
    private String sdt;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "anhnv", length = 50)
    private String anhNV;

    @Column(name = "gt", nullable = false)
    private boolean gioiTinh;

    @Column(name = "matkhau", length = 100, nullable = false)
    private String matKhau;
    
    @ManyToOne
    @JoinColumn(name = "mavt", nullable = false)
    private VaiTro mavt;
    
   
    //
    public NhanVien() {
    }
    
    public NhanVien(String ho, String ten, String sdt, String email, boolean gt, String matKhau ) {
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.gioiTinh = gt;
        this.matKhau = matKhau;
       
    }
    //

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnhNV() {
        return anhNV;
    }

    public void setAnhNV(String anhNV) {
        this.anhNV = anhNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public VaiTro getMavt() {
        return mavt;
    }

    public void setMavt(VaiTro mavt) {
        this.mavt = mavt;
    }

    @Override
    public String toString() {
        return ho + " " + ten;
    }

	

}
