package com.example.phts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    @RequestMapping("home")
    public String index() {
        return "index";
    }

    @RequestMapping("/employees")
    public String employees() {

        return "employees";
    }
}