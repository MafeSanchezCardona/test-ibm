package com.test.ibm.service;

import com.test.ibm.dto.AdviserDto;

import java.util.List;

/**
 * Class for business logic of the Adviser
 */
public interface AdviserService {

    /**
     * Method for created an adviser
     * @param adviserDto
     */
    void save(AdviserDto adviserDto);

    /**
     * Method for deleted an adviser
     * @param adviserDto
     */
    void delete(AdviserDto adviserDto);

    /**
     * Method for get all advisers
     * @return
     */
    List<AdviserDto> list();

    /**
     * Method for updated an adviser
     * @param adviserDto
     */
    void update(AdviserDto adviserDto);
}
