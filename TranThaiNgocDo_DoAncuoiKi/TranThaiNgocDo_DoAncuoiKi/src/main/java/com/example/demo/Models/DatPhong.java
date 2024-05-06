package com.example.demo.Models;
import java.math.BigDecimal;
import java.security.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "datphong")
public class DatPhong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "madp")
    private int madp;

	@ManyToOne
	@JoinColumn(name = "map", nullable = false)
	private Phong mp;

	@Column(name = "ngaynhan", nullable = false)
    private Timestamp ngayNhan; // Sử dụng java.sql.Timestamp thay vì java.util.Date

    @Column(name = "ngaytra", nullable = false)
    private Timestamp ngayTra; 

	@Column(name = "tinhtrang")
    private boolean tinhTrang;

    @Column(name = "tenkh", length = 50, nullable = false)
    private String tenKH;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "sdt", length = 20, nullable = false)
    private String sdt;

	@ManyToOne
	@JoinColumn(name = "manv", nullable = false)
	private NhanVien manv;


	@Column(name = "tongtiendat",precision = 10, scale = 2, nullable = false)
	private BigDecimal tongTienDat;

	    
	    // Constructors
	    public DatPhong() {}

	    public DatPhong(int MaDP, Phong MaPhong, Timestamp NgayNhan, Timestamp NgayTra, boolean TinhTrang, String TenKH, String Email, String SDT, BigDecimal TongTienDat,NhanVien manv) {
	        this.madp = MaDP;
	        this.mp = MaPhong;
	        this.ngayNhan = NgayNhan;
	        this.ngayTra = NgayTra;
	        this.tinhTrang = TinhTrang;
	        this.tenKH = TenKH;
	        this.email = Email;
	        this.sdt = SDT;
	        this.tongTienDat = TongTienDat;
			this.manv=manv;
	    }
	 //getters, and setters

		public int getMadp() {
			return madp;
		}

		public void setMadp(int madp) {
			this.madp = madp;
		}

		public Phong getMp() {
			return mp;
		}

		public void setMp(Phong mp) {
			this.mp = mp;
		}

		public Timestamp getNgayNhan() {
			return ngayNhan;
		}

		public void setNgayNhan(Timestamp ngayNhan) {
			this.ngayNhan = ngayNhan;
		}

		public Timestamp getNgayTra() {
			return ngayTra;
		}

		public void setNgayTra(Timestamp ngayTra) {
			this.ngayTra = ngayTra;
		}

		public boolean isTinhTrang() {
			return tinhTrang;
		}

		public void setTinhTrang(boolean tinhTrang) {
			this.tinhTrang = tinhTrang;
		}

		public String getTenKH() {
			return tenKH;
		}

		public void setTenKH(String tenKH) {
			this.tenKH = tenKH;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSdt() {
			return sdt;
		}

		public void setSdt(String sdt) {
			this.sdt = sdt;
		}

		public NhanVien getManv() {
			return manv;
		}

		public void setManv(NhanVien manv) {
			this.manv = manv;
		}

		public BigDecimal getTongTienDat() {
			return tongTienDat;
		}

		public void setTongTienDat(BigDecimal tongTienDat) {
			this.tongTienDat = tongTienDat;
		}

		
	    
}
