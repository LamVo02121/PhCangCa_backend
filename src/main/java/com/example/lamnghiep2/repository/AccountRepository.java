package com.example.lamnghiep2.repository;

import com.example.lamnghiep2.model.LN_Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository <LN_Account, Integer> {
    Optional<LN_Account> findLN_AccountByUsername(String taikhoan);

    Boolean existsByUsername(String taikhoan);
}
