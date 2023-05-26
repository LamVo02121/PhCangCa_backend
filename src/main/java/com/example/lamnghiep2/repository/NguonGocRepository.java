package com.example.lamnghiep2.repository;

import com.example.lamnghiep2.model.LN_DM_Nguon_Goc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NguonGocRepository extends JpaRepository<LN_DM_Nguon_Goc, Integer> {

}
