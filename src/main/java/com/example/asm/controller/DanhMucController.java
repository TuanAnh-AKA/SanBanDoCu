package com.example.asm.controller;

import com.example.asm.model.DanhMuc;
import com.example.asm.repository.DanhMucRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/danh-muc")
public class DanhMucController {
    private DanhMucRepository repo = new DanhMucRepository();

    @GetMapping
    public String danhSach(Model model) {
        model.addAttribute("dsDanhMuc", repo.findAll());
        return "danhmuc-list";
    }

    @GetMapping("/them")
    public String formThem(Model model) {
        model.addAttribute("danhMuc", new DanhMuc());
        return "danhmuc-form";
    }

    @PostMapping("/luu")
    public String luu(@ModelAttribute DanhMuc dm) {
        repo.save(dm);
        return "redirect:/danh-muc";
    }

    @GetMapping("/sua/{id}")
    public String sua(@PathVariable Long id, Model model) {
        model.addAttribute("danhMuc", repo.findById(id));
        return "danhmuc-form";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable Long id) {
        repo.delete(id);
        return "redirect:/danh-muc";
    }
}
