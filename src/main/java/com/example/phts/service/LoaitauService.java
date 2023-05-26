package com.example.phts.service;

import com.example.phts.repository.LoaitauRepository;
import com.example.phts.user.Loaitau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LoaitauService {
    @Autowired
    private LoaitauRepository repo;
    public List<Loaitau> listAll(){

        return (List<Loaitau>) repo.findAll();
    }


    public Loaitau get(Integer maLT) throws LoaitauNotFoundException {
        Optional<Loaitau> result = repo.findById(maLT);
        if(result.isPresent()){
            return result.get();
        }
        throw new LoaitauNotFoundException("Không tìm thấy"+maLT);
    }
}
