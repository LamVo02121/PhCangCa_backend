package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_DM_Loai_Vat_Nuoi;
import com.example.lamnghiep2.service.LoaiVatNuoiNotFoundException;
import com.example.lamnghiep2.service.LoaiVatNuoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoaiVatNuoiController {
    @Autowired private LoaiVatNuoiService service;

    @GetMapping("/qly_loai_vat_nuoi")
    public String qlyLoaiVatNuoi(Model model) {
        List<LN_DM_Loai_Vat_Nuoi> listLNLoaiVatNuoi = service.listAll();
        model.addAttribute("listLNLoaiVatNuoi", listLNLoaiVatNuoi);
        return "DS_LoaiVatNuoi";
    }

    @GetMapping("/add_LoaiVatNuoi")
    public String addLoaiVatNuoi(Model model) {
        model.addAttribute("LoaiVatNuoi", new LN_DM_Loai_Vat_Nuoi());
        model.addAttribute("pageTitle", "Thêm loại vật nuôi");
        return "form_add_loaivatnuoi";
    }

    @PostMapping ("/loaivatnuoi/save")
    public String saveLoaiVatNuoi(LN_DM_Loai_Vat_Nuoi acc) {
        service.save(acc);
        return "redirect:/qly_loai_vat_nuoi";
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

    @GetMapping("/loaivatnuoi/delete/{id}")
    public String deleteLoaiVatNuoi(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (LoaiVatNuoiNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
        }
        return "redirect:/qly_loai_vat_nuoi";
    }
}
