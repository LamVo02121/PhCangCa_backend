package com.example.PhCangCa.service;

import com.example.PhCangCa.Repository.HangThuySanRepository;
import com.example.PhCangCa.entity.HangThuySan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HangThuySanService {
    @Autowired private HangThuySanRepository repo;

    public List<HangThuySan> listAll(){
        return (List<HangThuySan>) repo.findAll();
    }

<<<<<<< HEAD
    public HangThuySan save(HangThuySan h){
        return repo.save(h);
    }

    public HangThuySan getById(Integer id) throws NotFoundException {
=======
    public void add(HangThuySan h){
        repo.save(h);
    }

    public HangThuySan getById(Integer id) throws HangNotFoundException {
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
        Optional<HangThuySan> h = repo.findById(id);
        if(h.isPresent()){
            return h.get();
        }
<<<<<<< HEAD
        throw new NotFoundException("Không tìm thấy hàng với ID " + id);
    }

    public void delById(Integer id) throws NotFoundException {
        Long cnt = repo.countById(id);
        if(cnt == null || cnt == 0){
            throw new NotFoundException("Không tìm thấy hàng với ID " + id);
=======
        throw new HangNotFoundException("Không tìm thấy hàng với ID " + id);
    }

    public void delById(Integer id) throws HangNotFoundException {
        Long cnt = repo.countById(id);
        if(cnt == null || cnt == 0){
            throw new HangNotFoundException("Không tìm thấy hàng với ID " + id);
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
        }
        repo.deleteById(id);
    }
}
