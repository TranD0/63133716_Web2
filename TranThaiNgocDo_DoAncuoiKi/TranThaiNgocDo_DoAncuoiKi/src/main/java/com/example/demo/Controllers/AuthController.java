// package com.example.demo.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import jakarta.servlet.http.HttpSession;
// import com.example.demo.Models.NhanVien;
// import com.example.demo.Repositories.NhanVienRepository;
// import java.util.Optional;
// import java.util.UUID;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private NhanVienRepository nhanVienRepository;

//     @Autowired
//     private BCryptPasswordEncoder bCryptPasswordEncoder;

//     @PostMapping("/login")
//     public String login(@RequestParam int maNV, @RequestParam String password, HttpSession session) {
//         Optional<NhanVien> nhanVienOpt = nhanVienRepository.findById(maNV);
        
//         if (!nhanVienOpt.isPresent()) {
//             return "redirect:/auth/login?error=true";
//         }
        
//         NhanVien nhanVien = nhanVienOpt.get();
        
//         if (!bCryptPasswordEncoder.matches(password, nhanVien.getMatKhau())) {
//             return "redirect:/auth/login?error=true";
//         }
        
//         String sessionId = generateSessionId();
     
//         session.setAttribute("sessionId", sessionId);
//         session.setAttribute("maNV", maNV);
//         return sessionId;
//     }
// @GetMapping("/checkSession")
//     public String checkSession(HttpSession session) {
//         String sessionId = (String) session.getAttribute("sessionId");
//         if (sessionId != null) {
//             int maNV = (Integer) session.getAttribute("maNV");
//             return "Session is valid for maNV: " + maNV;
//         } else {
//             return "Session is invalid";
//         }
//     }
//        @PostMapping("/logout")
//     public String logout(HttpSession session) {
//         session.invalidate();
//         return "Logged out successfully";
//     }
//         private String generateSessionId() {
//             return UUID.randomUUID().toString();
//     }
// }
