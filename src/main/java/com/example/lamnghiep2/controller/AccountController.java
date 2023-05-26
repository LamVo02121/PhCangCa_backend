package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_Account;
import com.example.lamnghiep2.service.AccountService;
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
public class AccountController {
    @Autowired private AccountService service;

    @GetMapping("/qly_account")
    public String qlyAccount(Model model) {
        List<LN_Account> listLNAccount = service.listAll();
        model.addAttribute("listLNAccount", listLNAccount);
        return "DS_Account";
    }

    @GetMapping("/add_account")
    public String addAccount(Model model) {
        model.addAttribute("account", new LN_Account());
        model.addAttribute("pageTitle", "Thêm tài khoản mới");
        return "form_add_account";
    }

    @PostMapping ("/account/save")
    public String saveAccount(LN_Account acc) {
        service.save(acc);
        return "redirect:/qly_account";
    }

    @GetMapping("/account/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            LN_Account acc = service.get(id);
            model.addAttribute("account", acc);
            model.addAttribute("pageTitle", "Chỉnh sửa tài khoản");
            return "form_add_account";
        } catch (accountNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
            return "redirect:/qly_account";
        }
    }

    @GetMapping("/account/delete/{id}")
    public String deleteAccount(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (accountNotFoundException e) {
            ra.addFlashAttribute("message", "Error");
        }
        return "redirect:/qly_account";
    }
}
