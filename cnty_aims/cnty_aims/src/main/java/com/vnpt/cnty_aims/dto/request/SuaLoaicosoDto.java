package com.vnpt.cnty_aims.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuaLoaicosoDto {
    private int id;
    private String name;
    private String code;
    private String quy_mo;
    private String loai_hinh;
}
