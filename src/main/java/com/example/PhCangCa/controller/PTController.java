package com.example.PhCangCa.controller;

import com.example.PhCangCa.entity.HangThuySan;
import com.example.PhCangCa.entity.Loaitau;
import com.example.PhCangCa.entity.PhuongTien;
import com.example.PhCangCa.service.NotFoundException;
import com.example.PhCangCa.service.LTService;
import com.example.PhCangCa.service.PTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PTController {
    @Autowired private PTService service;
    @Autowired private LTService service1;

    @RequestMapping("/phTien")
    public String showListPT(Model model){
        List<PhuongTien> listPt = service.listAll();
        model.addAttribute("listPt", listPt);
        return "phTien";
    }

    @RequestMapping("/phTien/newForm")
    public String showNewForm(Model model){
        model.addAttribute("pt", new PhuongTien());
        List<Loaitau> listLT = service1.listAll();
        model.addAttribute("listLt", listLT);
        model.addAttribute("idLT", 0);
        model.addAttribute("pageTitle", "Thêm phương tiện");
        model.addAttribute("ngTao", "Tên người tạo");
//        model.addAttribute("act", "add");
        return "phTienForm";
    }

    @RequestMapping("/phTien/create")
    public String create(PhuongTien pt, RedirectAttributes mes){
        pt.setIsActive(1);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        pt.setCreateDate(currentTime);
        pt.setIdNV(1);
        service.save(pt);

        mes.addFlashAttribute("message", "Lưu thành công!");
        return "redirect:/phTien";
    }

    @RequestMapping("/phTien/update/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes mes) {
        try {
            PhuongTien pt = service.getById(id);
            model.addAttribute("pt", pt);
            List<Loaitau> listLT = service1.listAll();
            model.addAttribute("listLt", listLT);
//            model.addAttribute("idLT", pt.getId_LT());
            model.addAttribute("pageTitle", "Chỉnh sửa thông tin phương tiện (ID: " + id + ")");
            model.addAttribute("ngTao", "Tên người cập nhật");
//            model.addAttribute("act", "update");
            return "phTienForm";
        } catch (NotFoundException e) {
            mes.addFlashAttribute("message", e.getMessage());
            return "redirect:/phTien";
        }
    }

    @RequestMapping("/phTien/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes mes) {
        try {
            service.delById(id);
            mes.addFlashAttribute("message", "Xóa thành công!");
        } catch (NotFoundException e) {
            mes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/phTien";
    }
}
