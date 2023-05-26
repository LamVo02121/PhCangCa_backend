package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.LN_DM_Giong_Cay_Trong;
import com.example.lamnghiep2.repository.GiongCayTrongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiongCayTrongService {
    @Autowired private GiongCayTrongRepository repo;

    public List<LN_DM_Giong_Cay_Trong> listAll() {

        return (List<LN_DM_Giong_Cay_Trong>) repo.findAll();
    }

    public void save(LN_DM_Giong_Cay_Trong N_Goc) {
        repo.save(N_Goc);
    }

    public LN_DM_Giong_Cay_Trong get(Integer id) throws GiongCayTrongNotFoundException {
        Optional<LN_DM_Giong_Cay_Trong> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new GiongCayTrongNotFoundException("Không tìm thấy giống cây trồng này");
    }

    public void delete(Integer id) throws GiongCayTrongNotFoundException{
        repo.deleteById(id);
        throw new GiongCayTrongNotFoundException("Không tìm thấy giống cây trồng này");
    }
}
