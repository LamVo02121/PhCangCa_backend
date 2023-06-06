package com.example.PhCangCa.Repository;

import com.example.PhCangCa.entity.PhuongTien;
import org.springframework.data.repository.CrudRepository;

public interface PTRepository extends CrudRepository<PhuongTien, Integer>{


    Long countById(Integer id);
}
