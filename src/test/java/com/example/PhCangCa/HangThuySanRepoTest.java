package com.example.PhCangCa;

import com.example.PhCangCa.Repository.HangThuySanRepository;
import com.example.PhCangCa.entity.HangThuySan;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.swing.text.html.Option;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class HangThuySanRepoTest {
    @Autowired private HangThuySanRepository repo;

    @Test
    public void testAdd(){
        HangThuySan h = new HangThuySan();
        h.setTenLoai("Cá ngừ");
        h.setIsActive(1);
        h.setIsDelete(0);
        h.setCreateUser("user1");
        h.setCreateUsername("Nguyen Van C");
        //convert date
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        h.setCreateDate(currentTime);
        h.setIdNV(1);
        HangThuySan saveHangThuySan = repo.save(h);

        Assertions.assertThat(saveHangThuySan).isNotNull();
        Assertions.assertThat(saveHangThuySan.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<HangThuySan> h = repo.findAll();
        Assertions.assertThat(h).hasSizeGreaterThan(0);

        for(HangThuySan i: h){
            System.out.println(i);
        }
    }

    @Test
    public void testUpdate(){
        Integer hangId = 1;
        Optional<HangThuySan> optionalHang = repo.findById(hangId);
        HangThuySan h = optionalHang.get();
        h.setIsActive(0);
        repo.save(h);

        HangThuySan updateHang = repo.findById(hangId).get();
        Assertions.assertThat(updateHang.getIsActive()).isEqualTo(0);
    }

    @Test
    public void testGetHangById(){
        Integer hangId = 4;
        Optional<HangThuySan> optionalHang = repo.findById(hangId);
        Assertions.assertThat(optionalHang).isPresent();
        System.out.println(optionalHang.get());
    }

    @Test
    public void testDelete(){
        Integer hangId = 12;
        repo.deleteById(hangId);

        Optional<HangThuySan> optionalHang = repo.findById(hangId);
        Assertions.assertThat(optionalHang).isNotPresent();
    }
}



