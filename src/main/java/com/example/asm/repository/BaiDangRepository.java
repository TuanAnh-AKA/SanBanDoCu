package com.example.asm.repository;

import com.example.asm.model.BaiDang;

import java.util.ArrayList;
import java.util.List;

public class BaiDangRepository {
    public static List<BaiDang> dsBD = new ArrayList<>();
    private static Long index = 6L; // sau 5 danh mục
    static {
        DanhMucRepository dm = new DanhMucRepository();
        dsBD.add(new BaiDang(1L, "Bán iPhone 11", "Điện thoại còn mới 90%",dm.findById(1L) , true));
        dsBD.add(new BaiDang(2L, "Laptop Dell XPS", "Máy chạy tốt, pin khỏe", dm.findById(2L) , false));
        dsBD.add(new BaiDang(3L, "Xe máy Wave", "Xe chạy ổn định, tiết kiệm xăng", dm.findById(3L) , true));
        dsBD.add(new BaiDang(4L, "Nồi cơm điện", "Nồi cơm điện Sharp 1.8L", dm.findById(4L) , false));
        dsBD.add(new BaiDang(5L, "Sách Lập trình Java", "Sách còn mới, ít ghi chú", dm.findById(5L) , true));
    }
    public List<BaiDang> getAll() {
        return dsBD;
    }

    public void save(BaiDang baiDang) {
        if (baiDang.getId() == null) {
            baiDang.setId(index++);
            dsBD.add(baiDang);
        } else {
            for (int i = 0; i < dsBD.size(); i++) {
                if (dsBD.get(i).getId().equals(baiDang.getId())) {
                    dsBD.set(i, baiDang);
                    return;
                }
            }
            dsBD.add(baiDang);
        }
    }

    public void delete(Long id) {
        dsBD.removeIf(p -> p.getId().equals(id));
    }

    public BaiDang findById(Long id) {
        return dsBD.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
