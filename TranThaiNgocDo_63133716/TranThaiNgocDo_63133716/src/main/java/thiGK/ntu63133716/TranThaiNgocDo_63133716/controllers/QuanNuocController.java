package thiGK.ntu63133716.TranThaiNgocdo_63133716.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thiGK.ntu63133716.TranThaiNgocdo_63133716.models.DTOQuanNuoc;
public class QuanNuocController {
	 @GetMapping("/Home")
	    public String showIndexPage() {
	        return "Index";
	    }
	 @GetMapping("/themMoiQN")
		public String showForm(Model mm) {
	        DTOQuanNuoc quannuocNull = new DTOQuanNuoc();
	        mm.addAttribute("svDTO", quannuocNull);
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
		public String listStudent(ModelMap mm) {
		    mm.addAttribute("dsSV", dsDoUong);
		    return "douong_getAll";
		}

}
