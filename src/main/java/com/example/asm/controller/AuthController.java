package com.example.asm.controller;

import com.example.asm.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    // 👉 Trang login
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // 👉 Xử lý login
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model) {
        // Giả sử tài khoản đúng là: admin / 123
        if ("admin".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            return "redirect:/home"; // Đúng → vào trang chủ
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            return "login"; // Sai → quay lại login
        }
    }

    // 👉 Trang chủ sau khi đăng nhập thành công
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
