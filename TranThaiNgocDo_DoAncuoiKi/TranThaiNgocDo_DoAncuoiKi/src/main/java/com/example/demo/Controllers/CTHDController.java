package com.example.demo.controllers;


import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.Models.CTHD;
import com.example.demo.Models.DichVu;
import com.example.demo.Models.HoaDon;
import com.example.demo.Repositories.CTHDRepository;
import com.example.demo.Services.CTHDService;
import com.example.demo.Services.DatPhongService;
import com.example.demo.Services.DichVuService;
import com.example.demo.Services.HoaDonService;
import com.example.demo.Services.PhongService;


@Controller
@RequestMapping("/Admin/CTHD")
public class CTHDController {
    @Autowired CTHDService cthdService;
    @Autowired HoaDonService donService;
    @Autowired DichVuService dichVuService;
    @Autowired PhongService phongService;
    @Autowired DatPhongService datPhongService;
    @Autowired CTHDRepository cthdRepository;
    @GetMapping("/Them/{maHD}")
    public String hienTrangThem(Model model,@PathVariable int maHD) {
        List<DichVu> dv = dichVuService.getAllCon();
        HoaDon hoaDon = donService.getBYID(maHD);
        model.addAttribute("hoaDon",hoaDon);
        model.addAttribute("dichVuList", dv);
        model.addAttribute("cthd", new CTHD());
        model.addAttribute("pageTitle", "Thêm chi tiết hóa đơn");
        return "CTHD/Form";
    }

   
@GetMapping("/Index")
	public String getAll(Model model) {
        List<CTHD> ds = cthdService.getAll();
		model.addAttribute("cthdList", ds);
		return "CTHD/Index";
	}
    	@PostMapping("/Luu")
    public String luu(CTHD cthd,RedirectAttributes ra ) {
       cthdService.add(cthd);
       DichVu dichVu = dichVuService.getDichVuBYID(cthd.getDichVu().getMaDV());
       dichVu.setSoLuong(dichVu.getSoLuong()-cthd.getSoLuong());
       dichVuService.addDichVu(dichVu);
       HoaDon hoaDon = donService.getBYID(cthd.getHoaDon().getMaHD());
       BigDecimal tien=cthdRepository.TongTienCT(hoaDon.getMaHD());
       hoaDon.setTongTien(hoaDon.getTongTien().add(tien));
       donService.add(hoaDon);
        ra.addFlashAttribute("message","đã thêm chi tiết mới thành công!");
        return "redirect:/Admin/HoaDon/Index"; 
    }
  @GetMapping("/Detail/{maHD}")
public String chiTietHoaDon(@PathVariable int maHD, Model model) {
    HoaDon hoaDon = donService.getBYID(maHD);
    List<CTHD> chiTietList = cthdRepository.findByMaHD(maHD);
    model.addAttribute("hoadon", hoaDon);
    model.addAttribute("cthdList", chiTietList);
    return "CTHD/Index"; 
}
	
}
