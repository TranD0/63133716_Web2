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
import com.example.demo.Models.LoaiPhong;
import com.example.demo.Services.LoaiPhongService;
@Controller
@RequestMapping("/LoaiPhong")
public class LoaiPhongController {
	@Autowired LoaiPhongService loaiPhongService;
	@GetMapping("/Index")
	public String getAll(Model model, @Param("tuKhoa") String tuKhoa, @RequestParam(name = "soTrang", defaultValue = "1") Integer soTrang) {
		Page<LoaiPhong> dsLP = loaiPhongService.findAll(soTrang);	
        
        if(tuKhoa!=null){
            dsLP = this.loaiPhongService.searchLP(tuKhoa,soTrang);
            model.addAttribute("tuKhoa", tuKhoa);
        }
        
        model.addAttribute("TongSoTrang",dsLP.getTotalPages());	
        model.addAttribute("TrangHienTai", soTrang);

		model.addAttribute("loaiPhong", dsLP);
		return "LoaiPhong/Index";
	}

    // @GetMapping("/Index")
	// public String getAll(Model model) {
    //     List<LoaiPhong> dsLP = loaiPhongService.getAllLoaiPhong();
	// 	model.addAttribute("loaiPhong", dsLP);
	// 	return "LoaiPhong/Index";
	// }
 
	
	@GetMapping("/Them")
    public String hienTrangThem(Model model) {
        model.addAttribute("loaiPhong", new LoaiPhong());
        model.addAttribute("pageTitle", "Thêm loại phòng");
        return "LoaiPhong/FormLP";
    }
    @GetMapping("/Sua/{malp}")
    public String hienTrangSua(@PathVariable("malp") int id,Model model,RedirectAttributes ra ) {
      
       LoaiPhong loaiPhong =loaiPhongService.getLoaiPhongBYID(id);
       loaiPhong.setMaLP(id);
        model.addAttribute("loaiPhong", loaiPhong);
        model.addAttribute("pageTitle", "Sửa loại phòng (Mã: "+id+")");
        return "LoaiPhong/FormLP";
    }
    @GetMapping("/Xoa/{malp}")
    public String hienTrangXoa(@PathVariable("malp") int id, RedirectAttributes ra) {
        loaiPhongService.deleteLoaiPhong(id);
        ra.addFlashAttribute("message","đã xóa thành công!");
        return "redirect:/LoaiPhong/Index"; 
    }

    @PostMapping("/Luu")
    public String themLoaiPhong(LoaiPhong loaiPhong,RedirectAttributes ra ) {
        loaiPhongService.addLoaiPhong(loaiPhong);
        ra.addFlashAttribute("message","đã thêm loại phòng mới thành công!");
        return "redirect:/LoaiPhong/Index"; 
    }


}
