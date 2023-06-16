package com.example.PhCangCa.service;

import com.example.PhCangCa.Repository.CgCaRepository;
import com.example.PhCangCa.entity.CangCa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CgCaService {
    @Autowired
    private CgCaRepository repo;

    public List<CangCa> listAll(){
        return (List<CangCa>) repo.findAll();
    }

    public CangCa save(CangCa h){
        return repo.save(h);
    }

    public CangCa getById(Integer id) throws NotFoundException {
        Optional<CangCa> h = repo.findById(id);
        if(h.isPresent()){
            return h.get();
        }
        throw new NotFoundException("Không tìm thấy hàng với ID " + id);
    }

    public void delById(Integer id) throws NotFoundException {
        Long cnt = repo.countById(id);
        if(cnt == null || cnt == 0){
            throw new NotFoundException("Không tìm thấy hàng với ID " + id);
        }
        repo.deleteById(id);
    }

}
