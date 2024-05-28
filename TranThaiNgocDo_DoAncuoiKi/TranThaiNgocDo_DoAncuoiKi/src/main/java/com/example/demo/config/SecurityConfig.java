package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

       @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
       
            .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/images/**", "/css/**", "/", "/script/**")
                .permitAll()
                .requestMatchers("/Admin/NhanVien/**").hasAuthority("ADMIN")
                .anyRequest().authenticated())
                .formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/Admin/Index", true)
                .permitAll())
                .logout((logout) -> logout
                .logoutUrl("/logout") // Thêm dòng này để chỉ định URL cho việc logout
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true) 
                .deleteCookies("JSESSIONID")
                .permitAll());
        return http.build();
    }
    
}

 

