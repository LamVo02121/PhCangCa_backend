package com.mycompany.csud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CsudService {
    @Autowired private CsudRepository repo;

    public List<Csud> listAll() {
        return (List<Csud>) repo.findAll();
    }

    public void save(Csud csud) {
        repo.save(csud);
    }

    public Csud get(Integer id) throws CsudNotFoundException {
        Optional<Csud> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CsudNotFoundException("Không tìm thấy cơ sở nào với ID " + id);
    }

    public void delete(Integer id) throws CsudNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new CsudNotFoundException("Không tìm thấy cơ sở nào với ID " + id);
        }
        repo.deleteById(id);
    }
}
