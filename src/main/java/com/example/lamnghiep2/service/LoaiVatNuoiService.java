package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.LN_DM_Loai_Vat_Nuoi;
import com.example.lamnghiep2.model.LN_DM_Nguon_Goc;
import com.example.lamnghiep2.repository.LoaiVatNuoiRepository;
import com.example.lamnghiep2.repository.NguonGocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiVatNuoiService {
    @Autowired private LoaiVatNuoiRepository repo;

    public List<LN_DM_Loai_Vat_Nuoi> listAll() {

        return (List<LN_DM_Loai_Vat_Nuoi>) repo.findAll();
    }

    public void save(LN_DM_Loai_Vat_Nuoi LoaiVatNuoi) {
        repo.save(LoaiVatNuoi);
    }
}
