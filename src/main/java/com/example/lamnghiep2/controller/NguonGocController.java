package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_DM_Nguon_Goc;
import com.example.lamnghiep2.service.NguonGocNotFoundException;
import com.example.lamnghiep2.service.NguonGocService;
//import com.example.lamnghiep2.service.accountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200/", allowCredentials = "true")
public class NguonGocController {
    @Autowired private NguonGocService service;

    @GetMapping("/qly_dm_nguon_goc")
    public List<LN_DM_Nguon_Goc> qly_DM_NguonGoc() {
        List<LN_DM_Nguon_Goc> listDmNguonGoc = service.listAll();
        return listDmNguonGoc;
    }

    @PostMapping ("/nguongoc/save")
    public LN_DM_Nguon_Goc saveNguonGoc(@RequestBody LN_DM_Nguon_Goc N_Goc) {
        service.save(N_Goc);
        return N_Goc;
    }

    @PutMapping("/nguongoc/edit/{id}")
    public ResponseEntity<LN_DM_Nguon_Goc> showEditForm(@PathVariable("id") Integer id, @RequestBody LN_DM_Nguon_Goc NG) {
        service.save(NG);
        return new ResponseEntity<LN_DM_Nguon_Goc>(HttpStatus.OK);
    }

    @DeleteMapping ("/nguongoc/delete/{id}")
    public ResponseEntity<?> deleteNguonGoc(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (NguonGocNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
