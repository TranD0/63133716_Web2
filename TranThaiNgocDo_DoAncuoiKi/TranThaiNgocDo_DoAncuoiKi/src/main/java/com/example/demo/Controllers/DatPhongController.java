package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Models.DatPhong;
import com.example.demo.Models.LoaiPhong;
import com.example.demo.Models.NhanVien;
import com.example.demo.Services.DatPhongService;
@Controller
@RequestMapping("/Admin/DatPhong")
public class DatPhongController {

    @Autowired
    private DatPhongService datPhongService;
    @PostMapping("/Them")
public String themDatPhong(@RequestParam("maLP") LoaiPhong maLP,
                           @RequestParam("ngayNhan") String ngayNhanStr,
                           @RequestParam("ngayTra") String ngayTraStr,
                           @RequestParam("tenKH") String tenKH,
                           @RequestParam("sdt") String sdt,
                           @RequestParam("manv") NhanVien maNV,
                           @RequestParam("tinhTrang") boolean tinhTrang,
                           Model model) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    
    // Chuyển đổi từ chuỗi sang LocalDateTime
    LocalDateTime ngayNhan = LocalDateTime.parse(ngayNhanStr, formatter);
    LocalDateTime ngayTra = LocalDateTime.parse(ngayTraStr, formatter);
    
    // Tạo đối tượng DatPhong từ thông tin được gửi từ form
    DatPhong datPhong = new DatPhong();
    datPhong.setMalp(maLP);
    datPhong.setNgayNhan(ngayNhan);
    datPhong.setNgayTra(ngayTra);
    datPhong.setTenKH(tenKH);
    datPhong.setSdt(sdt);
    datPhong.setManv(maNV);
    datPhong.setTinhTrang(tinhTrang);
    // Lưu thông tin đặt phòng vào cơ sở dữ liệu
    datPhongService.add(datPhong);

    // Redirect hoặc trả về view bạn muốn sau khi lưu thành công
    // Ví dụ:
    return "redirect:/Admin/DatPhong/Index"; // Điều hướng về danh sách đặt phòng sau khi đã thêm
}
    // @GetMapping("/Index")
    // public String danhSachDatPhong(Model model) {
    //     List<DatPhong> danhSachDatPhong = datPhongService.getAll();
    //     model.addAttribute("danhSachDatPhong", danhSachDatPhong);
    //     return "DatPhong/Index";
    // }
       @GetMapping("/Index")
    	public String getAll(Model model, @Param("tuKhoa") String tuKhoa, @RequestParam(name = "soTrang", defaultValue = "1") Integer soTrang) {
			Page<DatPhong> ds = datPhongService.findAll(soTrang);	
			
			if(tuKhoa!=null){
				ds = this.datPhongService.search(tuKhoa,soTrang);
				model.addAttribute("tuKhoa", tuKhoa);
			}
			
			model.addAttribute("TongSoTrang",ds.getTotalPages());	
			model.addAttribute("TrangHienTai", soTrang);

			model.addAttribute("danhSachDatPhong", ds);
			return "DatPhong/Index";
		}
}
