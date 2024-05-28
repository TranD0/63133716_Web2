package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Models.DichVu;
import com.example.demo.Services.DichVuService;
import com.example.demo.Services.NhanVienService;

@Controller 
@RequestMapping("/Admin/DichVu")
public class DichVuController {
    @Autowired DichVuService dichVuService;
    @Autowired NhanVienService nhanVienService;
    @GetMapping("/Index")
    	public String getAll(Model model, @Param("tuKhoa") String tuKhoa, @RequestParam(name = "soTrang", defaultValue = "1") Integer soTrang) {
			Page<DichVu> ds = dichVuService.findAll(soTrang);	
			
			if(tuKhoa!=null){
				ds = this.dichVuService.search(tuKhoa,soTrang);
				model.addAttribute("tuKhoa", tuKhoa);
			}
			
			model.addAttribute("TongSoTrang",ds.getTotalPages());	
			model.addAttribute("TrangHienTai", soTrang);

			model.addAttribute("dichVu", ds);
			return "DichVu/Index";
		}
    @GetMapping("/Them")
    public String hienTrangThem(Model model) {
        model.addAttribute("dichVu", new DichVu());
        model.addAttribute("pageTitle", "Thêm dịch vụ");
        return "DichVu/FormDV";
    }
    @GetMapping("/Xoa/{maDV}")
   		 public String hienTrangXoa(@PathVariable("maDV") int id, RedirectAttributes ra) {
       		dichVuService.deleteDichVu(id);
        ra.addFlashAttribute("message","đã xóa thành công!");
        return "redirect:/Admin/DichVu/Index"; 
    	}
    @GetMapping("/Sua/{maP}")
		public String hienTrangSua(@PathVariable("maP") int id,Model model,RedirectAttributes ra ) {
		   DichVu dichVu =dichVuService.getDichVuBYID(id);
           dichVu.setMaDV(id);
			model.addAttribute("dichVu", dichVu);
			model.addAttribute("pageTitle", "Sửa Dịch Vụ (Mã: "+id+")");
			return "DichVu/FormDV";
		}
		@PostMapping("/Luu")
    public String luuDichVu(DichVu dichVu,RedirectAttributes ra ) {
       dichVuService.addDichVu(dichVu);
        ra.addFlashAttribute("message","đã thêm dịch vụ mới thành công!");
        return "redirect:/Admin/DichVu/Index"; 
    }
}
