package com.example.demo.controllers;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.Services.NhanVienService;
import com.example.demo.Models.NhanVien;

@Controller
@RequestMapping("/Admin/NhanVien")
public class NhanVienController {
    @Autowired NhanVienService nhanVienService;
     @GetMapping("/Index")
     public String getAll(Model model, @Param("tuKhoa") String tuKhoa, @RequestParam(name = "soTrang", defaultValue = "1") Integer soTrang) {
		Page<NhanVien> dsNV = nhanVienService.findAll(soTrang);	
        
        if(tuKhoa!=null){
            dsNV = this.nhanVienService.searchNV(tuKhoa,soTrang);
            model.addAttribute("tuKhoa", tuKhoa);
        }
        
        model.addAttribute("TongSoTrang",dsNV.getTotalPages());	
        model.addAttribute("TrangHienTai", soTrang);

		model.addAttribute("nhanvien", dsNV);
		return "NhanVien/Index";
	}
	// public String getAll(Model model) {
    //      List<NhanVien> dsNV = nhanVienService.getAllNhanVien();
	//  	model.addAttribute("nhanvien", dsNV);
	//  	return "NhanVien/Index";
	// }
	@GetMapping("/Them")
   		public String hienTrangThem(Model model) {
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("pageTitle", "Thêm Nhân Viên");
        return "NhanVien/FormNV";
    	}
	@PostMapping("/Luu")
    public String themLoaiPhong(NhanVien nhanVien,@RequestParam("anhNVfile") MultipartFile anhNV,RedirectAttributes ra ) throws IllegalStateException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String currentTime = dateFormat.format(new Date());
        String fileName=anhNV.getOriginalFilename();
        String DuoiFile = fileName.substring(fileName.lastIndexOf("."));
        // Lưu thông tin nhân viên vào cơ sở dữ liệu
        nhanVien.setAnhNV(currentTime+DuoiFile);
        nhanVienService.addNhanVien(nhanVien);
        String uploadDir = "D:\\63133716_Web2\\TranThaiNgocDo_DoAncuoiKi\\TranThaiNgocDo_DoAncuoiKi\\src\\main\\resources\\static\\images\\AnhNV";
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs(); // Tạo thư mục nếu chưa tồn tại
        }
        File file = new File(uploadPath, currentTime+DuoiFile);
        anhNV.transferTo(file);
        ra.addFlashAttribute("message", "Đã thêm nhân viên mới thành công!");
        return "redirect:/Admin/NhanVien/Index";
    } 
    //     @GetMapping("/Sua/{maNV}")
    // public String hienTrangSua(@PathVariable("maNV") int id,Model model,RedirectAttributes ra ) {
      
    //     NhanVien nhanVien =nhanVienService.getNhanVienBYID(id);
    //     nhanVien.setMaNV(id);
    //     model.addAttribute("nhanvien", nhanVien);
    //     model.addAttribute("pageTitle", "Sửa Nhân Viên(Mã: "+id+")");
    //     return "NhanVien/FormNV";
    // }
      @GetMapping("/Xoa/{maNV}")
    public String hienTrangXoa(@PathVariable("maNV") int id, RedirectAttributes ra) {
        NhanVien nhanvien =nhanVienService.getNhanVienBYID(id);
        nhanVienService.deleteNhanVien(id);
        String uploadDir = "D:\\63133716_Web2\\TranThaiNgocDo_DoAncuoiKi\\TranThaiNgocDo_DoAncuoiKi\\src\\main\\resources\\static\\images\\AnhNV";
        File folder = new File(uploadDir);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Kiểm tra xem tên file có chứa id của nhân viên đang xóa không
                    if (file.getName().contains(nhanvien.getAnhNV())) {
                        file.delete(); // Xóa file
                    }
                }
            }
        }
        ra.addFlashAttribute("message","đã xóa thành công!");
        return "redirect:/Admin/NhanVien/Index"; 
    }
    }


