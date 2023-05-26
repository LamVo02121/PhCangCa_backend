package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_DM_Loai_Vat_Nuoi;
import com.example.lamnghiep2.service.LoaiVatNuoiService;
import com.example.lamnghiep2.service.accountNotFoundException;
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
    public String qlyAccount(Model model) {
        List<LN_DM_Loai_Vat_Nuoi> listLNLoaiVatNuoi = service.listAll();
        model.addAttribute("listLNLoaiVatNuoi", listLNLoaiVatNuoi);
        return "DS_LoaiVatNuoi";
    }

    @GetMapping("/add_LoaiVatNuoi")
    public String addAccount(Model model) {
        model.addAttribute("LoaiVatNuoi", new LN_DM_Loai_Vat_Nuoi());
        model.addAttribute("pageTitle", "Thêm tài loại vật nuôi");
        return "form_add_loaivatnuoi";
    }

    @PostMapping ("/loaivatnuoi/save")
    public String addAccount(LN_DM_Loai_Vat_Nuoi acc) {
        service.save(acc);
        return "redirect:/qly_loai_vat_nuoi";
    }
//
//    @GetMapping("/account/edit/{id}")
//    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
//        try {
//            LN_Account acc = service.get(id);
//            model.addAttribute("account", acc);
//            model.addAttribute("pageTitle", "Chỉnh sửa tài khoản");
//            return "form_add_account";
//        } catch (accountNotFoundException e) {
//            ra.addFlashAttribute("message", "Error");
//            return "redirect:/qly_account";
//        }
//    }
//
//    @GetMapping("/account/delete/{id}")
//    public String deleteAccount(@PathVariable("id") Integer id, RedirectAttributes ra) {
//        try {
//            service.delete(id);
//        } catch (accountNotFoundException e) {
//            ra.addFlashAttribute("message", "Error");
//        }
//        return "redirect:/qly_account";
//    }
}
