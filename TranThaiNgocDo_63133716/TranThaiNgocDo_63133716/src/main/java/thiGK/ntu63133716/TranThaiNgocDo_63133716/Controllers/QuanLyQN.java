package thiGK.ntu63133716.TranThaiNgocDo_63133716.Controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu63133716.TranThaiNgocDo_63133716.models.*;

@Controller
public class QuanLyQN {
	@GetMapping("/themMoiDU")
	public String showForm(Model mm) {
		DTDoUong douongNull = new DTDoUong();
        mm.addAttribute("duDTO", douongNull);
        return "themDoUong_form";
    }
	@PostMapping("/themMoiDU")
	public String submitForm(@ModelAttribute("duDTO") DTDoUong du) {
	    return "themDoUong_OK";
	}
	 
}