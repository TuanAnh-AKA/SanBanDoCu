package com.example.asm.repository;

import com.example.asm.model.DanhMuc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DanhMucRepository {
    private static List<DanhMuc> dsDanhMuc = new ArrayList<>();
    private static Long index = 6L;

    static {
        dsDanhMuc.add(new DanhMuc(1L, "DM01", "Điện thoại", "Danh mục điện thoại cũ", "2025-01-01"));
        dsDanhMuc.add(new DanhMuc(2L, "DM02", "Laptop", "Danh mục laptop cũ", "2025-01-02"));
        dsDanhMuc.add(new DanhMuc(3L, "DM03", "Xe máy", "Danh mục xe máy cũ", "2025-01-03"));
        dsDanhMuc.add(new DanhMuc(4L, "DM04", "Đồ gia dụng", "Danh mục đồ gia dụng cũ", "2025-01-04"));
        dsDanhMuc.add(new DanhMuc(5L, "DM05", "Sách", "Danh mục sách cũ", "2025-01-05"));
    }

    public List<DanhMuc> findAll() {
        return dsDanhMuc;
    }

    public void save(DanhMuc dm) {
        if (dm.getId() == null) { // thêm mới
            dm.setId(index++);
            dsDanhMuc.add(dm);
        } else { // cập nhật
            for (int i = 0; i < dsDanhMuc.size(); i++) {
                if (dsDanhMuc.get(i).getId().equals(dm.getId())) {
                    dsDanhMuc.set(i, dm);
                    return;
                }
            }
            // nếu không tìm thấy thì coi như thêm mới
            dsDanhMuc.add(dm);
        }
    }

    public void delete(Long id) {
        dsDanhMuc.removeIf(d -> d.getId().equals(id));
    }

    public DanhMuc findById(Long id) {
        return dsDanhMuc.stream()
                .filter(dm -> dm.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}

