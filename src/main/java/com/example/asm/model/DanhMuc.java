package com.example.asm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DanhMuc {
    private Long id;
    private String maDanhMuc;
    private String tenDanhMuc;
    private String moTa;
    private String ngayTao;
}
