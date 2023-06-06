package com.example.PhCangCa.controller;

import com.example.PhCangCa.entity.HangThuySan;
<<<<<<< HEAD
import com.example.PhCangCa.service.NotFoundException;
=======
import com.example.PhCangCa.service.HangNotFoundException;
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
import com.example.PhCangCa.service.HangThuySanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
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
<<<<<<< HEAD
        return "hangTS";
    }

    @RequestMapping("/hangTS/newForm")
    public String showNewForm(Model model){
        model.addAttribute("hang", new HangThuySan());
        model.addAttribute("pageTitle", "Thêm loại hàng");
        model.addAttribute("ngTao", "Tên người tạo");
//        model.addAttribute("act", "add");
=======
        model.addAttribute("pageTitle", "Thêm loại hàng");
        return "hangTS";
    }

    @RequestMapping("/hangTS/new")
    public String showNewForm(Model model){
        model.addAttribute("hang", new HangThuySan());
        model.addAttribute("pageTitle", "Thêm loại hàng");
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
        return "hangTSForm";
    }

    //edit gọi lại qua id
<<<<<<< HEAD
    @RequestMapping("/hangTS/create")
    public String create(HangThuySan h, RedirectAttributes mes){
=======
    @RequestMapping("/hangTS/add")
    public String add(HangThuySan h, RedirectAttributes mes){
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
        h.setIsActive(1);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        h.setCreateDate(currentTime);
<<<<<<< HEAD
        h.setIdNV(1);
        service.save(h);

=======

        service.add(h);
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
        mes.addFlashAttribute("message", "Lưu thành công!");
        return "redirect:/hangTS";
    }

<<<<<<< HEAD
//    @RequestMapping("/hangTS/update")
//    public String update(HangThuySan h, RedirectAttributes mes){
//        java.util.Date dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String currentTime = sdf.format(dt);
//        h.setUpdateDate(currentTime);
//        h.setIdNV(1);
//        service.save(h);
//
//        mes.addFlashAttribute("message", "Lưu thành công!");
//        return "redirect:/hangTS";
//    }

    @RequestMapping("/hangTS/update/{id}")
=======
    @RequestMapping("/hangTS/edit/{id}")
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes mes) {
        try {
            HangThuySan h = service.getById(id);
            model.addAttribute("hang", h);
            model.addAttribute("pageTitle", "Chỉnh sửa thông tin loại hàng (ID: " + id + ")");
<<<<<<< HEAD
            model.addAttribute("ngTao", "Tên người cập nhật");
//            model.addAttribute("act", "update");
            return "hangTSForm";
        } catch (NotFoundException e) {
=======
            return "hangTSForm";
        } catch (HangNotFoundException e) {
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
            mes.addFlashAttribute("message", e.getMessage());
            return "redirect:/hangTS";
        }
    }

    @RequestMapping("/hangTS/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes mes) {
        try {
            service.delById(id);
            mes.addFlashAttribute("message", "Xóa thành công!");
<<<<<<< HEAD
        } catch (NotFoundException e) {
=======
        } catch (HangNotFoundException e) {
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
            mes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/hangTS";
    }
}
