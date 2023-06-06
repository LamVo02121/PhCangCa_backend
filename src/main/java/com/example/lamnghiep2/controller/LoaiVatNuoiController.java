package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_DM_Loai_Vat_Nuoi;
import com.example.lamnghiep2.repository.LoaiVatNuoiRepository;
import com.example.lamnghiep2.service.LoaiVatNuoiNotFoundException;
import com.example.lamnghiep2.service.LoaiVatNuoiService;
import com.nimbusds.jose.shaded.gson.JsonArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:4200/")
public class LoaiVatNuoiController {
    @Autowired
    private LoaiVatNuoiService service;

    @GetMapping("/qly_loai_vat_nuoi")
    public ResponseEntity<List<LN_DM_Loai_Vat_Nuoi>> qlyLoaiVatNuoi(Model model) {
        List<LN_DM_Loai_Vat_Nuoi> listLNLoaiVatNuoi = service.listAll();
        model.addAttribute("listLNLoaiVatNuoi", listLNLoaiVatNuoi);
        return new ResponseEntity<List<LN_DM_Loai_Vat_Nuoi>>(listLNLoaiVatNuoi, HttpStatus.OK);
    }

    @GetMapping("/add_LoaiVatNuoi")
    public String addLoaiVatNuoi(Model model) {
        model.addAttribute("LoaiVatNuoi", new LN_DM_Loai_Vat_Nuoi());
        model.addAttribute("pageTitle", "Thêm loại vật nuôi");
        return "form_add_loaivatnuoi";
    }

    //    @PostMapping ("/loaivatnuoi/save")
//    public ResponseEntity<LN_DM_Loai_Vat_Nuoi> saveLoaiVatNuoi(LN_DM_Loai_Vat_Nuoi acc) {
//        service.save(acc);
//        return new ResponseEntity<LN_DM_Loai_Vat_Nuoi>(acc, HttpStatus.OK);
//    }
    @PostMapping("/loaivatnuoi/save")
    public ResponseEntity<LN_DM_Loai_Vat_Nuoi> saveLoaiVatNuoi(@RequestBody LN_DM_Loai_Vat_Nuoi acc) {
        service.save(acc);
        return new ResponseEntity<LN_DM_Loai_Vat_Nuoi>(acc, HttpStatus.OK);
    }

    @PutMapping("/loaivatnuoi/edit/{id}")
    public ResponseEntity<LN_DM_Loai_Vat_Nuoi> EditLoaiVatNuoi(@PathVariable("id") Integer id, @RequestBody LN_DM_Loai_Vat_Nuoi acc) {
        service.save(acc);
        return new ResponseEntity<LN_DM_Loai_Vat_Nuoi>(acc, HttpStatus.OK);
    }

    @GetMapping("/loaivatnuoi/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            LN_DM_Loai_Vat_Nuoi loaiVatNuoi = service.get(id);
            model.addAttribute("LoaiVatNuoi", loaiVatNuoi);
            model.addAttribute("pageTitle", "Chỉnh sửa thông tin loại vật nuôi");
            return "form_add_loaivatnuoi";
        } catch (LoaiVatNuoiNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
            return "redirect:/qly_loai_vat_nuoi";
        }
    }

    @DeleteMapping("/loaivatnuoi/delete/{id}")
    public ResponseEntity<?> deleteLoaiVatNuoi(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (LoaiVatNuoiNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
