package com.example.PhCangCa.Repository;

import com.example.PhCangCa.entity.CangCa;
import com.example.PhCangCa.entity.HangThuySan;
import org.springframework.data.repository.CrudRepository;

public interface CgCaRepository extends CrudRepository<CangCa, Integer> {
    public Long countById(Integer id);
}
