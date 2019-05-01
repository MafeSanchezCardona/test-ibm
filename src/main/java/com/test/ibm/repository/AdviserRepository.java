package com.test.ibm.repository;

import com.test.ibm.entity.Adviser;

import java.util.List;

public interface AdviserRepository {

    void save(Adviser adviser);

    void delete(Adviser adviser);

    List<Adviser> list();

    void update(Adviser adviser);
}
