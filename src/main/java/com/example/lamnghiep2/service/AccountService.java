package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.LN_Account;
import com.example.lamnghiep2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired private AccountRepository repo;
    public List<LN_Account> listAll() {

        return (List<LN_Account>) repo.findAll();
    }
    public void save(LN_Account acc) {

        repo.save(acc);
    }
    public LN_Account get(Integer id) throws accountNotFoundException {
        Optional<LN_Account> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new accountNotFoundException("Không tìm thấy tài khoản này");
    }

    public void delete(Integer id) throws accountNotFoundException {
        repo.deleteById(id);
        throw new accountNotFoundException("Không tìm thấy tài khoản này");
    }

}