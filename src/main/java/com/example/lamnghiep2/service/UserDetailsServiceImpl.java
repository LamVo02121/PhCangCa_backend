package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.LN_Account;
import com.example.lamnghiep2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  AccountRepository accountRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String taikhoan) throws UsernameNotFoundException {
    LN_Account lnAccount = accountRepository.findLN_AccountByUsername(taikhoan)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + taikhoan));

    return UserDetailsImpl.build(lnAccount);
  }
  public Optional<LN_Account> getByTaiKhoan(String taikhoan){
    return accountRepository.findLN_AccountByUsername(taikhoan);
  }
}
