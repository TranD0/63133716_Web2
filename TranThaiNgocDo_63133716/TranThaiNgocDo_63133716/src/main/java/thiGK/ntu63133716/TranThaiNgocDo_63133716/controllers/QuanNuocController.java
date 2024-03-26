package thiGK.ntu63133716.TranThaiNgocdo_63133716.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu63133716.TranThaiNgocdo_63133716.models.DTOQuanNuoc;
@Controller
public class QuanNuocController {
	 @GetMapping("/Home")
	    public String showIndexPage() {
	        return "Index";
	    }
	 @GetMapping("/themMoiQN")
		public String showForm(Model mm) {
	        DTOQuanNuoc quannuocNull = new DTOQuanNuoc();
	        mm.addAttribute("qnDTO", quannuocNull);
	        return "themQuanNuoc_form";
	    }
		@PostMapping("/themMoiQN")
		public String submitForm(@ModelAttribute("qnDTO") DTOQuanNuoc qn) {
		    return "themQuanNuoc_OK";
		}
		
		static List<DTOQuanNuoc> dsDoUong=  new ArrayList<DTOQuanNuoc>();
		static {
			dsDoUong.add(new DTOQuanNuoc("0001", "cà phê",5,200));
			dsDoUong.add(new DTOQuanNuoc("0002", "nước lọc",4,200));
			 }

		@GetMapping("/danhsachDU")
		public String listdouong(ModelMap mm) {
		    mm.addAttribute("dsSV",dsDoUong);
		    return "douong_getAll";
		}
		 @GetMapping("/timkiem")
		    public String search(ModelMap mm, @RequestParam("keyword") String keyword) {
		        // Tìm kiếm các đồ uống dựa trên keyword
		        List<DTOQuanNuoc> ketQuaTimKiem = dsDoUong.stream()
		                .filter(douong -> douong.getTenDoUong().toLowerCase().contains(keyword.toLowerCase()))
		                .collect(Collectors.toList());

		        // Đưa kết quả tìm kiếm vào ModelMap
		        mm.addAttribute("ketQuaTimKiem", ketQuaTimKiem);
		        return "ketqua_timkiem";
		    }

}
