package com.test.ibm.service;

import com.test.ibm.entity.Adviser;
import com.test.ibm.repository.AdviserRepository;
import com.test.ibm.repository.impl.AdviserRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdviserServiceTest {

    @Autowired
    private AdviserRepository adviserRepository = new AdviserRepositoryImpl();

    @Before
    public void setUp() {
        Adviser adviser = new Adviser();
        adviser.setIdentification(12131L);
        adviser.setName("Mafe");
        adviser.setSpecialty("Especialidad 1");

        adviserRepository.save(adviser);
    }

    @Test
    public void getAllAdviser() {
        Assert.assertNotNull(adviserRepository.list());
    }
}
