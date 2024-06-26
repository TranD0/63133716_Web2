package com.example.demo.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.Models.DatPhong;
import com.example.demo.Models.LoaiPhong;
import com.example.demo.Models.Phong;
import com.example.demo.Repositories.DatPhongRepository;
import com.example.demo.Services.DatPhongService;
import com.example.demo.Services.DichVuService;
import com.example.demo.Services.HoaDonService;
import com.example.demo.Services.LoaiPhongService;
import com.example.demo.Services.PhongService;
@Controller
@RequestMapping("/Admin/Phong")
public class PhongController {
		@Autowired PhongService  phongService ;
		@Autowired LoaiPhongService  loaiPhongService ;
		  @Autowired HoaDonService donService;
		  @Autowired DatPhongRepository datPhongRepository;
		  @Autowired DatPhongService datPhongService;
		  @Autowired DichVuService dichVuService;
		@GetMapping("/Index")
		public String getAll(Model model, @Param("tuKhoa") String tuKhoa, @RequestParam(name = "soTrang", defaultValue = "1") Integer soTrang) {
			
			Page<Phong> dsP = phongService.findAll(soTrang);	
			
			if(tuKhoa!=null && !tuKhoa.isEmpty()){
				dsP = this.phongService.searchP(tuKhoa,soTrang);
				model.addAttribute("tuKhoa", tuKhoa);
			}
			List<DatPhong> listDatPhong = datPhongRepository.findAll();
        	model.addAttribute("listDatPhong", listDatPhong);
			List<LoaiPhong> listLoaiPhong = loaiPhongService.getAllLoaiPhong();
			model.addAttribute("listLoaiPhong", listLoaiPhong);
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
			List<DatPhong> listDatPhong = datPhongRepository.findByTinhTrang();
        	model.addAttribute("listDatPhong", listDatPhong);
			List<LoaiPhong> listLoaiPhong = loaiPhongService.getAllLoaiPhong();
			model.addAttribute("listLoaiPhong", listLoaiPhong);
		   Phong Phong =phongService.getPhongBYID(id);
		   	Phong.setMaP(id);
			model.addAttribute("Phong", Phong);
			model.addAttribute("pageTitle", "Sửa phòng (Mã: "+id+")");
			return "Phong/FormP";
		}
		@PreAuthorize("hasAuthority('ADMIN')")
		@GetMapping("/Xoa/{maP}")
   		 public String hienTrangXoa(@PathVariable("maP") int id, RedirectAttributes ra) {
       		phongService.deletePhong(id);
        ra.addFlashAttribute("message","đã xóa thành công!");
        return "redirect:/Admin/Phong/Index"; 
    	}
		@PostMapping("/Luu")
		public String themPhong(Phong Phong,RedirectAttributes ra ) {
			phongService.addPhong(Phong);
			ra.addFlashAttribute("message","đã thêm phòng mới thành công!");
			return "redirect:/Admin/Phong/Index"; 
		}
	
}
