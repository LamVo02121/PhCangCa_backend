package com.mycompany;

import com.mycompany.csud.Csud;
import com.mycompany.csud.CsudRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CsudRepositoryTests {
    @Autowired private CsudRepository repo;

    @Test
    public void testAddNew() {
        Csud csud = new Csud();
        csud.setTenCoSo("alex.stevenson@gmail.com");
        csud.setLoaiGiongUong("alex123456");
        csud.setNgayUong("Alex");
        csud.setSoLuong("Stevenson");

        Csud savedCsud = repo.save(csud);

        Assertions.assertThat(savedCsud).isNotNull();
        Assertions.assertThat(savedCsud.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Csud> csuds = repo.findAll();
        Assertions.assertThat(csuds).hasSizeGreaterThan(0);

        for (Csud csud : csuds) {
            System.out.println(csud);
        }
    }

    @Test
    public void testUpdate() {
        Integer csudId = 1;
        Optional<Csud> optionalCsud = repo.findById(csudId);
        Csud csud = optionalCsud.get();
        csud.setLoaiGiongUong("hello2000");
        repo.save(csud);

        Csud updatedCsud = repo.findById(csudId).get();
        Assertions.assertThat(updatedCsud.getLoaiGiongUong()).isEqualTo("hello2000");
    }

    @Test
    public void testGet() {
        Integer csudId = 2;
        Optional<Csud> optionalCsud = repo.findById(csudId);
        Assertions.assertThat(optionalCsud).isPresent();
        System.out.println(optionalCsud.get());
    }

    @Test
    public void testDelete() {
        Integer csudId = 2;
        repo.deleteById(csudId);

        Optional<Csud> optionalCsud = repo.findById(csudId);
        Assertions.assertThat(optionalCsud).isNotPresent();
    }
}
