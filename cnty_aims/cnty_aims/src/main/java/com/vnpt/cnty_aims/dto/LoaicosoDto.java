package com.vnpt.cnty_aims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaicosoDto {
    private Integer id;
    private String name;
    private String code;
    private String quy_mo;
    private String loai_hinh;
}
