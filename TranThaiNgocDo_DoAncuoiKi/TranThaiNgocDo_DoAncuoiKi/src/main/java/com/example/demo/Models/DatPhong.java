package com.example.demo.Models;
import java.time.LocalDateTime;
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

	

	@Column(name = "ngaynhan", nullable = false)
    private LocalDateTime ngayNhan; 

    @Column(name = "ngaytra", nullable = false)
    private LocalDateTime ngayTra; 

	@Column(name = "tinhtrang")
    private boolean tinhTrang;

    @Column(name = "tenkh", length = 50, nullable = false)
    private String tenKH;

    @Column(name = "sdt", length = 20, nullable = false)
    private String sdt;
	@ManyToOne
	@JoinColumn(name = "manv", nullable = false)
	private NhanVien manv;

	@ManyToOne
    @JoinColumn(name = "malp", nullable = false)
    private LoaiPhong malp;

	    
	    // Constructors
	    public DatPhong() {}


		public DatPhong(int madp, LocalDateTime ngayNhan, LocalDateTime ngayTra, boolean tinhTrang, String tenKH, String sdt,
				NhanVien manv, LoaiPhong malp) {
			this.madp = madp;
			this.ngayNhan = ngayNhan;
			this.ngayTra = ngayTra;
			this.tinhTrang = tinhTrang;
			this.tenKH = tenKH;
			this.sdt = sdt;
			this.manv = manv;
			this.malp = malp;
		}


		public int getMadp() {
			return madp;
		}


		public void setMadp(int madp) {
			this.madp = madp;
		}


		public LocalDateTime getNgayNhan() {
			return ngayNhan;
		}


		public void setNgayNhan(LocalDateTime ngayNhan) {
			this.ngayNhan = ngayNhan;
		}


		public LocalDateTime getNgayTra() {
			return ngayTra;
		}


		public void setNgayTra(LocalDateTime ngayTra) {
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


		public LoaiPhong getMalp() {
			return malp;
		}


		public void setMalp(LoaiPhong malp) {
			this.malp = malp;
		}


		@Override
		public String toString() {
			return  ngayNhan+tenKH;
		}

	 
}
