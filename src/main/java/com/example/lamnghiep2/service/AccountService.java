package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.account;
import com.example.lamnghiep2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired private AccountRepository repo;
    public List<account> listAll() {
        return (List<account>) repo.findAll();
    }
    public void save(account acc) {
        repo.save(acc);
    }
    public account get(Integer id) throws accountNotFoundException {
        Optional<account> result = repo.findById(id);
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