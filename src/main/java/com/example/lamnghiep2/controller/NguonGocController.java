package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_DM_Nguon_Goc;
import com.example.lamnghiep2.service.NguonGocNotFoundException;
import com.example.lamnghiep2.service.NguonGocService;
//import com.example.lamnghiep2.service.accountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class NguonGocController {
    @Autowired private NguonGocService service;

    @GetMapping("/qly_dm_nguon_goc")
    public String qly_DM_NguonGoc(Model model) {
        List<LN_DM_Nguon_Goc> listDmNguonGoc = service.listAll();
        model.addAttribute("listDmNguonGoc", listDmNguonGoc);
        return "DS_Nguon_Goc";
    }

    @GetMapping("/add_Nguongoc")
    public String addAccount(Model model) {
        model.addAttribute("Nguon_Goc", new LN_DM_Nguon_Goc());
        model.addAttribute("pageTitle", "Thêm nguồn gốc");
        return "form_add_nguon_goc";
    }

    @PostMapping ("/nguongoc/save")
    public String addAccount(LN_DM_Nguon_Goc N_Goc) {
        service.save(N_Goc);
        return "redirect:/qly_dm_nguon_goc";
    }

    @GetMapping("/nguongoc/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            LN_DM_Nguon_Goc N_Goc = service.get(id);
            model.addAttribute("Nguon_Goc", N_Goc);
            model.addAttribute("pageTitle", "Chỉnh sửa thông tin nguồn gốc");
            return "form_add_nguon_goc";
        } catch (NguonGocNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
            return "redirect:/qly_dm_nguon_goc";
        }
    }

    @GetMapping("/nguongoc/delete/{id}")
    public String deleteAccount(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (NguonGocNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
        }
        return "redirect:/qly_dm_nguon_goc";
    }
}
