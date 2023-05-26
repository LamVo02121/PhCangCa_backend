package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.LN_DM_Nguon_Goc;
import com.example.lamnghiep2.repository.NguonGocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguonGocService {
    @Autowired private NguonGocRepository repo;

    public List<LN_DM_Nguon_Goc> listAll() {

        return (List<LN_DM_Nguon_Goc>) repo.findAll();
    }

    public void save(LN_DM_Nguon_Goc N_Goc) {
        repo.save(N_Goc);
    }

    public LN_DM_Nguon_Goc get(Integer id) throws NguonGocNotFoundException {
        Optional<LN_DM_Nguon_Goc> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NguonGocNotFoundException("Không tìm thấy tài khoản này");
    }

    public void delete(Integer id) throws NguonGocNotFoundException{
        repo.deleteById(id);
        throw new NguonGocNotFoundException("Không tìm thấy tài khoản này");
    }
}
