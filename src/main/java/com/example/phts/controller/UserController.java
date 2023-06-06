package com.example.phts.controller;

import com.example.phts.service.UserNotFoundException;
import com.example.phts.service.UserService;
import com.example.phts.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

//    @GetMapping("/employees")
//    public String showUserList(Model model){
//        List<User> listUsers = service.listAll();
//        model.addAttribute("listUsers", listUsers);
//        return "employees";
//    }
    @GetMapping("/employees")
    public ResponseEntity<List<User>> showUserList(Model model) {
        List<User> listUser= service.listAll();
        model.addAttribute("listUser", listUser);
        return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")Integer id) throws UserNotFoundException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/employees/new")
    public String showNewForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle","Thêm mới thành viên");
        return "user_form";
    }

    @PostMapping("/employees/save")
    public String saveUser(User user, RedirectAttributes ra ){
        service.save(user);
        ra.addFlashAttribute("message","Lưu thành công!");
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model,RedirectAttributes ra) {
        try {

            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle","Edit User(ID:"+id+")");
            return "user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/employees";
        }
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id,RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message","Xóa thành công");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/employees";
    }
}
