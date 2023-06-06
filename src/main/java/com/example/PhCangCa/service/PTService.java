package com.example.PhCangCa.service;

import com.example.PhCangCa.Repository.PTRepository;
import com.example.PhCangCa.entity.PhuongTien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PTService {
    @Autowired private PTRepository repo;

    public List<PhuongTien> listAll(){
        return (List<PhuongTien>) repo.findAll();
    }

    public PhuongTien save(PhuongTien pt){
        return repo.save(pt);
    }

    public void delById(Integer id) throws NotFoundException {
        Long cnt = repo.countById(id);
        if(cnt == null || cnt == 0){
            throw new NotFoundException("Không tìm thấy hàng với ID " + id);
        }
        repo.deleteById(id);
    }

    public PhuongTien getById(Integer id) throws NotFoundException {
        Optional<PhuongTien> h = repo.findById(id);
        if(h.isPresent()){
            return h.get();
        }
        throw new NotFoundException("Không tìm thấy hàng với ID " + id);
    }
}
