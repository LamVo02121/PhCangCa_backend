package com.example.lamnghiep2;

import com.example.lamnghiep2.model.LN_Account;
import com.example.lamnghiep2.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class AccountRepositoryTest {
    @Autowired private AccountRepository account;

    @Test
    public void testAddAccount() {
        LN_Account acc = new LN_Account();
        acc.setEmail("tn53875@gmail.com");
        acc.setFirstname("Nguyen");
        acc.setLastname("Huu Thinh");
        acc.setPassword("123123");

        LN_Account saveacc = account.save(acc);
    }
}
