package com.test.ibm.service;

import com.test.ibm.dto.AdviserDto;

import java.util.List;

public interface AdviserService {

    void save(AdviserDto adviserDto);

    void delete(AdviserDto adviserDto);

    List<AdviserDto> list();

    void update(AdviserDto adviserDto);
}
