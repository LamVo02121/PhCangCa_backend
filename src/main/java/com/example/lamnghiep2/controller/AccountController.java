package com.example.lamnghiep2.controller;

import com.example.lamnghiep2.model.LN_Account;
import com.example.lamnghiep2.service.AccountService;
import com.example.lamnghiep2.service.accountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200/", allowCredentials = "true")
public class AccountController {
    @Autowired private AccountService service;

    @GetMapping("/qly_account")
    public ResponseEntity<List<LN_Account>> qlyAccount(Model model) {
        List<LN_Account> listLNAccount = service.listAll();
        model.addAttribute("listLNAccount", listLNAccount);
        return new ResponseEntity<List<LN_Account>>(listLNAccount, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public LN_Account getAccById(@PathVariable("id") Integer id, RedirectAttributes ra) {
        LN_Account acc = null;
        try {
            acc = service.get(id);
        } catch (accountNotFoundException e) {
            ra.addFlashAttribute("Message", "Error");
        }
        return acc;
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
