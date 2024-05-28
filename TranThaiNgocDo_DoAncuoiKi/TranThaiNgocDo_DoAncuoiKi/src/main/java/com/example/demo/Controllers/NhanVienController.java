package com.example.demo.controllers;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.Services.NhanVienService;
import com.example.demo.Services.VaiTroService;
import com.example.demo.Models.NhanVien;
import com.example.demo.Models.VaiTro;

@Controller
@RequestMapping("/Admin/NhanVien")
public class NhanVienController {
    @Autowired NhanVienService nhanVienService;
    @Autowired VaiTroService vaiTroService;
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
            List<VaiTro> list = vaiTroService.getAllVaiTro();
            model.addAttribute("roles", list);
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("pageTitle", "Thêm Nhân Viên");
        return "NhanVien/FormNV";
    	}
	@PostMapping("/Luu")
    public String themNhanVien(NhanVien nhanVien,@RequestParam("anhNVfile") MultipartFile anhNV,RedirectAttributes ra ) throws IllegalStateException, IOException {
        if ((boolean)nhanVienService.emailExists(nhanVien.getEmail())) {
            ra.addFlashAttribute("message", "Email đã tồn tại!");
            ra.addFlashAttribute("nhanvien", nhanVien);
            return "redirect:/Admin/NhanVien/Them";
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String currentTime = dateFormat.format(new Date());
        String fileName=anhNV.getOriginalFilename();
        String DuoiFile = fileName.substring(fileName.lastIndexOf("."));
        // Lưu thông tin nhân viên vào cơ sở dữ liệu
        nhanVien.setAnhNV(currentTime+DuoiFile);
        String hashedPassword = BCrypt.hashpw(nhanVien.getMatKhau(), BCrypt.gensalt());
        nhanVien.setMatKhau(hashedPassword);
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
    @GetMapping("/KiemTraEmail")
@ResponseBody
public Map<String, Boolean> kiemTraEmail(@RequestParam("email") String email) {
    Map<String, Boolean> response = new HashMap<>();
    boolean exists = nhanVienService.emailExists(email);
    response.put("exists", exists);
    return response;
}

    
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


