package com.vnpt.cnty_aims.dao;

import java.util.*;

public interface LoaicosoDao {
    List<Map<String,Object>> listLoaicoso();

    List<Map<String, Object>> LoaicosoById(int id);

    List<Map<String, Object>> SearchByName(String name);

    int themLoaicoso(String name, String code, String quy_mo, String loai_hinh);
    int suaLoaicoso(int id, String name, String code, String quy_mo, String loai_hinh);
    int xoaLoaicoso(int id);
}
