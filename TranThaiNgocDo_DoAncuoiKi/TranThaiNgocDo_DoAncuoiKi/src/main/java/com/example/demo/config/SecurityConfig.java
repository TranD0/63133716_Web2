// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(authorize -> authorize
//                 .requestMatchers("/css/**", "/script/**", "/images/**").permitAll() // Cho phép truy cập các tệp tĩnh
//                 .requestMatchers("/Admin").hasRole("ADMIN")
//                 .anyRequest().authenticated()) // Yêu cầu xác thực cho mọi yêu cầu khác
//             .formLogin(form -> form
//             .loginProcessingUrl("/j_spring_security_check")
//                 .loginPage("/login") // Trang đăng nhập
//                 .usernameParameter("username")// tham số này nhận từ form login ở bước 3 có input  name='username'
//                 .passwordParameter("password")
//                 .defaultSuccessUrl("/Admin/AdminIndex")
//                 .failureUrl("/login?error=true") // Trang đăng nhập lại nếu đăng nhập thất bại
//                 .permitAll()); // Cho phép tất cả mọi người truy cập trang đăng nhập
//             // .logout(logout -> logout
//             //     .logoutUrl("/perform_logout") // URL xử lý yêu cầu đăng xuất
//             //     .deleteCookies("JSESSIONID")); // Xóa cookie khi đăng xuất

//         return http.build();
//     }
// }
