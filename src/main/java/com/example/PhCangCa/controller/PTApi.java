package com.example.PhCangCa.controller;

import com.example.PhCangCa.entity.HangThuySan;
import com.example.PhCangCa.entity.PhuongTien;
import com.example.PhCangCa.service.HangThuySanService;
import com.example.PhCangCa.service.NotFoundException;
import com.example.PhCangCa.service.PTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/phTien")
public class PTApi {
    private final PTService ptService;


    public PTApi(PTService ptService) {
        this.ptService = ptService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PhuongTien>> getAllPt(){
        List<PhuongTien> listPT = ptService.listAll();
        return new ResponseEntity<>(listPT, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PhuongTien> getTsById(@PathVariable("id") Integer id) throws NotFoundException {
        PhuongTien ts = ptService.getById(id);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PhuongTien> createTs(@RequestBody PhuongTien pt) {
//        ts.setIsActive(1);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        pt.setCreateDate(currentTime);
        pt.setIdNV(1);
        PhuongTien newTs = ptService.save(pt);
        return new ResponseEntity<>(newTs, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<PhuongTien> updateTs(@RequestBody PhuongTien pt, @PathVariable("id") Integer id) throws NotFoundException {
//        ts.setIsActive(1);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        pt.setUpdateDate(currentTime);
        pt.setId(id);
        PhuongTien h = ptService.getById(id);
        pt.setCreateDate(h.getCreateDate());
        pt.setIdNV(1);
        PhuongTien updateTs = ptService.save(pt);
        return new ResponseEntity<>(updateTs, HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteTs(@PathVariable("id") Integer id) throws NotFoundException {
        ptService.delById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
