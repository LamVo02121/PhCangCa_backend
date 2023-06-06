package com.example.PhCangCa.Repository;

import com.example.PhCangCa.entity.HangThuySan;
import org.springframework.data.repository.CrudRepository;

public interface HangThuySanRepository extends CrudRepository<HangThuySan, Integer> {
    public Long countById(Integer id);

}
