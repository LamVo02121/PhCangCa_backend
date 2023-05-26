package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_DM_Loai_Hinh_Doanh_Nghiep;
import com.example.lamnghiep2.service.LoaiHinhDoanhNghiepNotFoundException;
import com.example.lamnghiep2.service.LoaiHinhDoanhNghiepService;
import com.example.lamnghiep2.service.LoaiVatNuoiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoaiHinhDoanhNghiepController {
    @Autowired private LoaiHinhDoanhNghiepService service;

    @GetMapping("/qly_loai_hinh_doanh_nghiep")
    public String qlyLoaiHinhDoanhNghiep(Model model) {
        List<LN_DM_Loai_Hinh_Doanh_Nghiep> listLNLoaiHinhDoanhNghiep = service.listAll();
        model.addAttribute("listLNLoaiHinhDoanhNghiep", listLNLoaiHinhDoanhNghiep);
        return "DS_LoaiHinhDoanhNghiep";
    }

    @GetMapping("/add_LoaiHinhDoanhNghiep")
    public String addLoaihinhdoanhnghiep(Model model) {
        model.addAttribute("LoaiHinhDoanhNghiep", new LN_DM_Loai_Hinh_Doanh_Nghiep());
        model.addAttribute("pageTitle", "Thêm loại hình doanh nghiệp");
        return "form_add_loaihinhdoanhnghiep";
    }

    @PostMapping ("/loaihinhdoanhnghiep/save")
    public String saveLoaiHinhDoanhNghiep(LN_DM_Loai_Hinh_Doanh_Nghiep lhdn) {
        service.save(lhdn);
        return "redirect:/qly_loai_hinh_doanh_nghiep";
    }

    @GetMapping("/loaihinhdoanhnghiep/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            LN_DM_Loai_Hinh_Doanh_Nghiep lhdn = service.get(id);
            model.addAttribute("LoaiHinhDoanhNghiep", lhdn);
            model.addAttribute("pageTitle", "Chỉnh sửa loại hình doanh nghiệp");
            return "form_add_loaihinhdoanhnghiep";
        } catch (LoaiHinhDoanhNghiepNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
            return "redirect:/qly_loai_hinh_doanh_nghiep";
        }
    }

    @GetMapping("/loaihinhdoanhnghiep/delete/{id}")
    public String deleteLoaiHinhDoanhNghiep(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (LoaiHinhDoanhNghiepNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
        }
        return "redirect:/qly_loai_hinh_doanh_nghiep";
    }
}
