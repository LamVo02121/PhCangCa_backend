package com.example.PhCangCa.controller;

import com.example.PhCangCa.entity.HangThuySan;
import com.example.PhCangCa.service.HangNotFoundException;
import com.example.PhCangCa.service.HangThuySanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HangTSController {
    @Autowired private HangThuySanService service;

    @RequestMapping("/hangTS")
    public String showListUser(Model model){
        List<HangThuySan> listHang = service.listAll();
        model.addAttribute("listHang", listHang);
        model.addAttribute("pageTitle", "Thêm loại hàng");
        return "hangTS";
    }

    @RequestMapping("/hangTS/new")
    public String showNewForm(Model model){
        model.addAttribute("hang", new HangThuySan());
        model.addAttribute("pageTitle", "Thêm loại hàng");
        return "hangTSForm";
    }

    //edit gọi lại qua id
    @RequestMapping("/hangTS/add")
    public String add(HangThuySan h, RedirectAttributes mes){
        h.setIsActive(1);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        h.setCreateDate(currentTime);

        service.add(h);
        mes.addFlashAttribute("message", "Lưu thành công!");
        return "redirect:/hangTS";
    }

    @RequestMapping("/hangTS/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes mes) {
        try {
            HangThuySan h = service.getById(id);
            model.addAttribute("hang", h);
            model.addAttribute("pageTitle", "Chỉnh sửa thông tin loại hàng (ID: " + id + ")");
            return "hangTSForm";
        } catch (HangNotFoundException e) {
            mes.addFlashAttribute("message", e.getMessage());
            return "redirect:/hangTS";
        }
    }

    @RequestMapping("/hangTS/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes mes) {
        try {
            service.delById(id);
            mes.addFlashAttribute("message", "Xóa thành công!");
        } catch (HangNotFoundException e) {
            mes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/hangTS";
    }
}
