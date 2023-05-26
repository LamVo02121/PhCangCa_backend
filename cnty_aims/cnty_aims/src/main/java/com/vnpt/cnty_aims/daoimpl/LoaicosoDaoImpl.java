package com.vnpt.cnty_aims.daoimpl;

import com.vnpt.cnty_aims.dao.LoaicosoDao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class LoaicosoDaoImpl implements LoaicosoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> listLoaicoso(){
        String sql = "{ call listLoaicoso()}";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> LoaicosoById(int id){
        String sql = "{ call listLoaicoso(?)}";
        return jdbcTemplate.queryForList(sql, id);
    }

    @Override
    public List<Map<String, Object>> SearchByName(String name){
        String sql = "{ call SearchByName(?)}";
        return jdbcTemplate.queryForList(sql, name);
    }

    @Override
    public int themLoaicoso(String name, String code, String quy_mo, String loai_hinh) {
        String sql = "{ call cnty_aims.themLoaicoso(?,?,?,?)}";
        int affRow = jdbcTemplate.update(sql, name, code, quy_mo, loai_hinh);
        if (affRow == 0)
            System.out.println("Thêm thất bại.");
        return affRow;
    }

    @Override
    public int suaLoaicoso(int id, String name, String code, String quy_mo, String loai_hinh) {
        String sql = "{ call cnty_aims.suaLoaicoso(?,?,?,?,?)}";
        int affRow = jdbcTemplate.update(sql, id, name, code, quy_mo, loai_hinh);
        if (affRow == 0)
            System.out.println("Sửa thất bại.");
        return affRow;
    }

    @Override
    public int xoaLoaicoso(int id) {
        String sql = "{ call cnty_aims.xoaLoaicoso(?)}";
        int affRow = jdbcTemplate.update(sql, id);
        if (affRow == 0)
            System.out.println("Xoá thất bại.");
        return affRow;
    }

}
