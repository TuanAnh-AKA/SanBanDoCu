package com.example.asm.controller;

import com.example.asm.model.BaiDang;
import com.example.asm.model.DanhMuc;
import com.example.asm.repository.BaiDangRepository;
import com.example.asm.repository.DanhMucRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai-dang")
public class BaiDangController {
    private BaiDangRepository repo = new BaiDangRepository();
    private DanhMucRepository danhMucRepository = new DanhMucRepository();
    @GetMapping
    public String list(Model model) {
        model.addAttribute("dsBaiDang", repo.getAll());
        model.addAttribute("baiDang", new BaiDang());
        model.addAttribute("dsDanhMuc", danhMucRepository.findAll()); // lấy danh mục
        return "bai-dang";
    }

    @PostMapping("/luu")
    public String luu(@ModelAttribute BaiDang baiDang) {
        // Lấy id danh mục từ form
        Long dmId = baiDang.getDanhMuc().getId();

        // Tìm đối tượng DanhMuc thật trong repo
        DanhMuc dm = danhMucRepository.findById(dmId);
        if (dm != null) {
            baiDang.setDanhMuc(dm); // gắn lại object đầy đủ
        }

        repo.save(baiDang);
        return "redirect:/bai-dang";
    }


    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable Long id) {
        repo.delete(id);
        return "redirect:/bai-dang";
    }
    @GetMapping("/sua/{id}")
    public String sua(@PathVariable Long id, Model model) {
        BaiDang bd = repo.findById(id);
        if (bd == null) {
            return "redirect:/bai-dang"; // Nếu không tìm thấy thì quay lại danh sách
        }
        model.addAttribute("dsBaiDang", repo.getAll());
        model.addAttribute("baiDang", bd); // Nạp bài đăng cũ vào form
        model.addAttribute("dsDanhMuc", danhMucRepository.findAll()); // lấy danh mục
        return "bai-dang";
    }
}
