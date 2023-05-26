package com.mycompany.csud;

import org.springframework.data.repository.CrudRepository;

public interface CsudRepository extends CrudRepository<Csud, Integer> {
    public Long countById(Integer id);
}
