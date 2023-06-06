package com.example.PhCangCa.service;

import com.example.PhCangCa.Repository.LTRepository;
import com.example.PhCangCa.Repository.PTRepository;
import com.example.PhCangCa.entity.Loaitau;
import com.example.PhCangCa.entity.PhuongTien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LTService {
    @Autowired private LTRepository repo;

    public List<Loaitau> listAll(){
        return (List<Loaitau>) repo.findAll();
    }
}
