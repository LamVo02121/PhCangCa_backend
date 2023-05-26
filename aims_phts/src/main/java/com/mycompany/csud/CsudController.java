package com.mycompany.csud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CsudController {
    @Autowired private CsudService service;
    
    @GetMapping("/csuds")
    public String showUserList(Model model) {
        List<Csud> listCsuds = service.listAll();
        model.addAttribute("listCsuds", listCsuds);

        return "csuds";
    }

    @GetMapping("/csuds/new")
    public String showNewForm(Model model) {
        model.addAttribute("csud", new Csud());
        model.addAttribute("pageTitle", "Thêm mới cơ sở");
        return "csud_form";
    }

    @PostMapping("/csuds/save")
    public String saveUser(Csud csud, RedirectAttributes ra) {
        service.save(csud);
        ra.addFlashAttribute("message", "Cơ sở đã được lưu thành công.");
        return "redirect:/csuds";
    }

    @GetMapping("/csuds/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Csud csud = service.get(id);
            model.addAttribute("csud", csud);
            model.addAttribute("pageTitle", "Chỉnh sửa cơ sở (ID: " + id + ")");

            return "csud_form";
        } catch (CsudNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/csuds";
        }
    }

    @GetMapping("/csuds/delete/{id}")
    public String deleteCsud(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "Cơ sở " + id + " đã được xóa.");
        } catch (CsudNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/csuds";
    }
}
