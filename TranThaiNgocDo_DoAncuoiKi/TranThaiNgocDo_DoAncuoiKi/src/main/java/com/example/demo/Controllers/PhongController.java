package com.example.demo.controllers;
import java.util.List;
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

import com.example.demo.Models.LoaiPhong;
import com.example.demo.Models.Phong;
import com.example.demo.Services.LoaiPhongService;
import com.example.demo.Services.PhongService;
@Controller
@RequestMapping("/Phong")
public class PhongController {
		@Autowired PhongService  phongService ;
		@Autowired LoaiPhongService  loaiPhongService ;
		@GetMapping("/Index")
		public String getAll(Model model, @Param("tuKhoa") String tuKhoa, @RequestParam(name = "soTrang", defaultValue = "1") Integer soTrang) {
			Page<Phong> dsP = phongService.findAll(soTrang);	
			
			if(tuKhoa!=null){
				dsP = this.phongService.searchP(tuKhoa,soTrang);
				model.addAttribute("tuKhoa", tuKhoa);
			}
			
			model.addAttribute("TongSoTrang",dsP.getTotalPages());	
			model.addAttribute("TrangHienTai", soTrang);

			model.addAttribute("phong", dsP);
			return "Phong/Index";
		}
		// @GetMapping("/Index")
		// public String getAll(Model model) {
		// 	List<Phong> dsP = phongService.getAllPhong();		
		// 	model.addAttribute("phong", dsP);
		// 	return "Phong/Index";
		// }
		@GetMapping("/Them")
   		public String hienTrangThem(Model model) {
		 List<LoaiPhong> listLoaiPhong = loaiPhongService.getAllLoaiPhong();
        model.addAttribute("listLoaiPhong", listLoaiPhong);
        model.addAttribute("Phong", new Phong());
        model.addAttribute("pageTitle", "Thêm phòng");
        return "Phong/FormP";
    	}
		@GetMapping("/Sua/{maP}")
		public String hienTrangSua(@PathVariable("maP") int id,Model model,RedirectAttributes ra ) {
			List<LoaiPhong> listLoaiPhong = loaiPhongService.getAllLoaiPhong();
			model.addAttribute("listLoaiPhong", listLoaiPhong);
		   Phong Phong =phongService.getPhongBYID(id);
		   	Phong.setMaP(id);
			model.addAttribute("Phong", Phong);
			model.addAttribute("pageTitle", "Sửa phòng (Mã: "+id+")");
			return "Phong/FormP";
		}
		@GetMapping("/Xoa/{maP}")
   		 public String hienTrangXoa(@PathVariable("maP") int id, RedirectAttributes ra) {
       		phongService.deletePhong(id);
        ra.addFlashAttribute("message","đã xóa thành công!");
        return "redirect:/Phong/Index"; 
    	}
		@PostMapping("/Luu")
		public String themPhong(Phong Phong,RedirectAttributes ra ) {
			phongService.addPhong(Phong);
			ra.addFlashAttribute("message","đã thêm phòng mới thành công!");
			return "redirect:/Phong/Index"; 
		}
}
