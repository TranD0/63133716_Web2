package com.example.demo.controllers;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.demo.Models.CTHD;
import com.example.demo.Models.DatPhong;
import com.example.demo.Models.HoaDon;
import com.example.demo.Models.Phong;
import com.example.demo.Repositories.DatPhongRepository;
import com.example.demo.Services.CTHDService;
import com.example.demo.Services.DatPhongService;
import com.example.demo.Services.DichVuService;
import com.example.demo.Services.HoaDonService;
import com.example.demo.Services.PhongService;

@Controller 
@RequestMapping("/Admin/HoaDon")
public class HoaDonController {
      @Autowired CTHDService cthdService;
    @Autowired HoaDonService donService;
    @Autowired DichVuService dichVuService;
    @Autowired PhongService phongService;
    @Autowired DatPhongService datPhongService;
    @Autowired DatPhongRepository datPhongRepository;
    @GetMapping("/Index")
    public String getAll(Model model, @RequestParam(name = "startDate", required = false) LocalDateTime start, @RequestParam(name = "endDate", required = false) LocalDateTime end, @RequestParam(name = "soTrang", defaultValue = "1") Integer soTrang) {
        Page<HoaDon> ds;

        if (start != null && end != null) {
            ds = this.donService.search(start, end, soTrang);
            BigDecimal totalAmount = donService.TongTienHD(start, end);
            model.addAttribute("tuKhoa1", start);
            model.addAttribute("tuKhoa2", end);
            model.addAttribute("tong", totalAmount);
        } else {
            ds = this.donService.findAll(soTrang);
        }
        
        model.addAttribute("TongSoTrang", ds.getTotalPages());
        model.addAttribute("TrangHienTai", soTrang);
        model.addAttribute("HoaDon", ds);

        return "HoaDon/Index"; // Tên view
    }

     @PostMapping("/saveHoaDon")
    public String tinhTienVaTaoHoaDon(@RequestParam("maP") int maP, Model model) {
        Phong phong = phongService.getPhongBYID(maP);
        DatPhong datPhong = datPhongService.getBYID(phong.getMaP());

        HoaDon hoaDon = new HoaDon();
        hoaDon.setMadp(datPhong);
        hoaDon.setThoiGianTao(LocalDateTime.now());
        BigDecimal tong = datPhongRepository.tongTien(datPhong.getMadp());
        hoaDon.setTongTien(tong);
        hoaDon.setManv(datPhong.getManv());
    
    
        donService.add(hoaDon);
        phong.setTinhTrang(true);
        phong.setMadp(null);
        phongService.addPhong(phong);
        datPhong.setTinhTrang(true);
        datPhongService.add(datPhong);
        model.addAttribute("hoaDon", hoaDon);
        List<CTHD> ds = cthdService.getAll();
        model.addAttribute("cthd", ds);
        return "redirect:/Admin/Index";
    }
    
  
}