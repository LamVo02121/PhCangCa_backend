package com.example.PhCangCa.controller;

import com.example.PhCangCa.entity.CangCa;
import com.example.PhCangCa.entity.PhuongTien;
import com.example.PhCangCa.service.CgCaService;
import com.example.PhCangCa.service.NotFoundException;
import com.example.PhCangCa.service.PTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cang")
public class CangCaApi {
    private final CgCaService cgcaService;


    public CangCaApi(CgCaService cgcaService) {
        this.cgcaService = cgcaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CangCa>> getAllPt(){
        List<CangCa> listCg = cgcaService.listAll();
        return new ResponseEntity<>(listCg, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CangCa> getTsById(@PathVariable("id") Integer id) throws NotFoundException {
        CangCa ts = cgcaService.getById(id);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CangCa> createTs(@RequestBody CangCa cgca) {
//        ts.setIsActive(1);
//        java.util.Date dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String currentTime = sdf.format(dt);
//        pt.setCreateDate(currentTime);
//        pt.setIdNV(1);
        CangCa newTs = cgcaService.save(cgca);
        return new ResponseEntity<>(newTs, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CangCa> updateTs(@RequestBody CangCa cgca, @PathVariable("id") Integer id) throws NotFoundException {
//        ts.setIsActive(1);
//        java.util.Date dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String currentTime = sdf.format(dt);
//        pt.setUpdateDate(currentTime);
            cgca.setId(id);
//        PhuongTien h = ptService.getById(id);
//        pt.setCreateDate(h.getCreateDate());
//        pt.setIdNV(1);
        CangCa updatecg = cgcaService.save(cgca);
        return new ResponseEntity<>(updatecg, HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteTs(@PathVariable("id") Integer id) throws NotFoundException {
        cgcaService.delById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
