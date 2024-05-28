package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Models.VaiTro;
import com.example.demo.Services.VaiTroService;

import org.springframework.ui.Model;
@Controller 
@RequestMapping("/Admin/VaiTro")
public class VaiTroController {
    @Autowired VaiTroService vaiTroService;

       @GetMapping("/Index")
	public String getAll(Model model) {
      
        List<VaiTro> ds = vaiTroService.getAllVaiTro();
		model.addAttribute("vaiTro", ds);
		return "VaiTro/Index";
	}
    // @GetMapping("/Them")
    // public String hienTrangThem(Model model) {
    //     model.addAttribute("vaiTro", new VaiTro());
    //     model.addAttribute("pageTitle", "Thêm Vai trò");
    //     return "VaiTro/Form";
    // }
    // @GetMapping("/Sua/{mavt}")
    // public String hienTrangSua(@PathVariable("mavt") int id,Model model,RedirectAttributes ra ) {
      
    //    VaiTro vaiTro =vaiTroService.getVaiTroBYID(id);
    //    vaiTro.setMaVT(id);
    //     model.addAttribute("vaiTro", vaiTro);
    //     model.addAttribute("pageTitle", "Sửa Vai trò (Mã: "+id+")");
    //     return "VaiTro/Form";
    // }
    // @GetMapping("/Xoa/{mavt}")
    // public String hienTrangXoa(@PathVariable("mavt") int id, RedirectAttributes ra) {
    //     vaiTroService.deleteVaiTro(id);
    //     ra.addFlashAttribute("message","đã xóa thành công!");
    //     return "redirect:/Admin/VaiTro/Index"; 
    // }

    // @PostMapping("/Luu")
    // public String themVaiTro(VaiTro vaiTro,RedirectAttributes ra ) {
    //     vaiTroService.addVaiTro(vaiTro);
    //     ra.addFlashAttribute("message","đã thêm vai trò mới thành công!");
    //     return "redirect:/Admin/VaiTro/Index"; 
    // }
}
