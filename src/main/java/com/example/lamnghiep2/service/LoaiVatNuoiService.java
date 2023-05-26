package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.LN_DM_Loai_Vat_Nuoi;
import com.example.lamnghiep2.repository.LoaiVatNuoiRepository;
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

    public LN_DM_Loai_Vat_Nuoi get(Integer id) throws LoaiVatNuoiNotFoundException {
        Optional<LN_DM_Loai_Vat_Nuoi> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new LoaiVatNuoiNotFoundException("Không tìm thấy loại vật nuôi này");
    }

    public void delete(Integer id) throws LoaiVatNuoiNotFoundException {
        repo.deleteById(id);
        throw new LoaiVatNuoiNotFoundException("Không tìm thấy loại vật nuôi này");
    }
}
