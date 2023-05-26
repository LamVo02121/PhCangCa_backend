package com.vnpt.cnty_aims.resource;

import com.vnpt.cnty_aims.dao.LoaicosoDao;
import com.vnpt.cnty_aims.dto.base.PostResponseBaseDto;
import com.vnpt.cnty_aims.dto.request.SuaLoaicosoDto;
import com.vnpt.cnty_aims.dto.request.ThemLoaicosoDto;
import com.vnpt.cnty_aims.dto.request.XoaLoaicosoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoaicosoResource {
    @Autowired
    LoaicosoDao loaicosoDao;

    @PostMapping("/cnty_dm_loai_co_so")
    public ResponseEntity themLoaicoso(@RequestBody ThemLoaicosoDto request) {
        loaicosoDao.themLoaicoso(request.getName(),request.getCode(),request.getQuy_mo(),request.getLoai_hinh());
        return ResponseEntity.ok().body(
                PostResponseBaseDto.builder().message("Thêm thành công").statusCode(HttpStatus.OK.value()).build()
        );
//        return ResponseEntity.ok().body("ys");
    }

    @GetMapping("/cnty_dm_loai_co_so")
    public ResponseEntity listLoaicoso() {
        return  ResponseEntity.ok().body(loaicosoDao.listLoaicoso());

    }

    @PutMapping("/cnty_dm_loai_co_so")
    public ResponseEntity suaLoaicoso(@RequestBody SuaLoaicosoDto request) {
        loaicosoDao.suaLoaicoso(request.getId(),request.getName(),request.getCode(),request.getQuy_mo(),request.getLoai_hinh());
        return ResponseEntity.ok().body(
                PostResponseBaseDto.builder().message("Sửa thành công").statusCode(HttpStatus.OK.value()).build()
        );
    }

    @DeleteMapping("/cnty_dm_loai_co_so")
    public ResponseEntity xoaLoaicoso(@RequestBody XoaLoaicosoDto request) {
        loaicosoDao.xoaLoaicoso(request.getId());
        return ResponseEntity.ok().body(
                PostResponseBaseDto.builder().message("Xoá thành công").statusCode(HttpStatus.OK.value()).build()
        );
    }
}
