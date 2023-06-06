package com.example.PhCangCa.controller;

import com.example.PhCangCa.entity.HangThuySan;
import com.example.PhCangCa.service.HangThuySanService;
import com.example.PhCangCa.service.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/hangTS")
public class HangTSApi {
    private final HangThuySanService tsService;


    public HangTSApi(HangThuySanService tsService) {
        this.tsService = tsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<HangThuySan>> getAllTs(){
        List<HangThuySan> listTS = tsService.listAll();
        return new ResponseEntity<>(listTS, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HangThuySan> getTsById(@PathVariable("id") Integer id) throws NotFoundException {
        HangThuySan ts = tsService.getById(id);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HangThuySan> createTs(@RequestBody HangThuySan ts) {
//        ts.setIsActive(1);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        ts.setCreateDate(currentTime);
        ts.setIdNV(1);
        HangThuySan newTs = tsService.save(ts);
        return new ResponseEntity<>(newTs, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<HangThuySan> updateTs(@RequestBody HangThuySan ts, @PathVariable("id") Integer id) throws NotFoundException {
//        ts.setIsActive(1);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        ts.setUpdateDate(currentTime);
        ts.setId(id);
        HangThuySan h = tsService.getById(id);
        ts.setCreateDate(h.getCreateDate());
        ts.setIdNV(1);
        HangThuySan updateTs = tsService.save(ts);
        return new ResponseEntity<>(updateTs, HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteTs(@PathVariable("id") Integer id) throws NotFoundException {
        tsService.delById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
