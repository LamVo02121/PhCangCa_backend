package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_DM_Giong_Cay_Trong;
import com.example.lamnghiep2.service.GiongCayTrongNotFoundException;
import com.example.lamnghiep2.service.GiongCayTrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GiongCayTrongController {
    @Autowired private GiongCayTrongService service;

    @GetMapping("/qly_dm_giong_cay_trong")
    public String qly_DM_GiongCayTrong(Model model) {
        List<LN_DM_Giong_Cay_Trong> listDmGiongCayTrong = service.listAll();
        model.addAttribute("listDmGiongCayTrong", listDmGiongCayTrong);
        return "DS_GiongCayTrong";
    }

    @GetMapping("/add_GiongCayTrong")
    public String addGiongCayTrong(Model model) {
        model.addAttribute("GiongCayTrong", new LN_DM_Giong_Cay_Trong());
        model.addAttribute("pageTitle", "Thêm giống cây trồng");
        return "form_add_giongcaytrong";
    }

    @PostMapping ("/GiongCayTrong/save")
    public String saveGiongCayTrong(LN_DM_Giong_Cay_Trong gct) {
        service.save(gct);
        return "redirect:/qly_dm_giong_cay_trong";
    }

    @GetMapping("/GiongCayTrong/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            LN_DM_Giong_Cay_Trong gct = service.get(id);
            model.addAttribute("GiongCayTrong", gct);
            model.addAttribute("pageTitle", "Chỉnh sửa thông tin giống cây trồng");
            return "form_add_giongcaytrong";
        } catch (GiongCayTrongNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
            return "redirect:/qly_dm_giong_cay_trong";
        }
    }

    @GetMapping("/GiongCayTrong/delete/{id}")
    public String deleteGiongCayTrong(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (GiongCayTrongNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
        }
        return "redirect:/qly_dm_giong_cay_trong";
    }
}
