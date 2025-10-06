package com.example.asm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiDang {
    private Long id;
    private String tieuDe;
    private String moTa;
    private DanhMuc danhMuc;
    private boolean daDuyet;
}
