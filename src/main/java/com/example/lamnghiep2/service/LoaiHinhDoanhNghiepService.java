package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.LN_DM_Loai_Hinh_Doanh_Nghiep;
import com.example.lamnghiep2.repository.LoaiHinhDoanhNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiHinhDoanhNghiepService {
    @Autowired private LoaiHinhDoanhNghiepRepository repo;

    public List<LN_DM_Loai_Hinh_Doanh_Nghiep> listAll() {

        return (List<LN_DM_Loai_Hinh_Doanh_Nghiep>) repo.findAll();
    }

    public void save(LN_DM_Loai_Hinh_Doanh_Nghiep lhdn) {

        repo.save(lhdn);
    }

    public LN_DM_Loai_Hinh_Doanh_Nghiep get(Integer id) throws LoaiHinhDoanhNghiepNotFoundException {
        Optional<LN_DM_Loai_Hinh_Doanh_Nghiep> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new LoaiHinhDoanhNghiepNotFoundException("Không tìm thấy loại hình doanh nghiệp này");
    }

    public void delete(Integer id) throws LoaiHinhDoanhNghiepNotFoundException {
        repo.deleteById(id);
        throw new LoaiHinhDoanhNghiepNotFoundException("Không tìm thấy loại vật nuôi này");
    }
}
