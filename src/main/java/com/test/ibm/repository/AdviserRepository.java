package com.test.ibm.repository;

import com.test.ibm.entity.Adviser;

import java.util.List;

/**
 * Class for get data of the entity Adviser
 */
public interface AdviserRepository {

    /**
     * Method for created an adviser
     * @param adviser
     */
    void save(Adviser adviser);

    /**
     * Method for deleted an adviser
     * @param adviser
     */
    void delete(Adviser adviser);

    /**
     * Method for get all advisers
     * @return
     */
    List<Adviser> list();

    /**
     * Method for updated an adviser
     * @param adviser
     */
    void update(Adviser adviser);
}