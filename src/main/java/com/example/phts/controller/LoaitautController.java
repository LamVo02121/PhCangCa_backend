package com.example.phts.controller;

import com.example.phts.service.LoaitauService;
import com.example.phts.user.Loaitau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class LoaitautController {
    @Autowired
    private LoaitauService service;
    @GetMapping("/lt")
    public String showLoaitauList(Model model) {
        List<Loaitau> listLoaitau = service.listAll();
        model.addAttribute("listLoaitau", listLoaitau);
        return "lt";
    }
}
