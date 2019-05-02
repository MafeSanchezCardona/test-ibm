package com.test.ibm.service.impl;

import com.test.ibm.converter.AdviserConverter;
import com.test.ibm.dto.AdviserDto;
import com.test.ibm.repository.AdviserRepository;
import com.test.ibm.service.AdviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviserServiceImpl implements AdviserService {

    @Autowired
    private AdviserRepository adviserRepository;

    @Override
    public void save(AdviserDto adviserDto) {
        adviserRepository.save(AdviserConverter.dtoToEntity(adviserDto));
    }

    @Override
    public void delete(AdviserDto adviserDto) {
        adviserRepository.delete(AdviserConverter.dtoToEntity(adviserDto));
    }

    @Override
    public List<AdviserDto> list() {
        return AdviserConverter.entityToDto(adviserRepository.list());
    }

    @Override
    public void update(AdviserDto adviserDto) {
        adviserRepository.update(AdviserConverter.dtoToEntity(adviserDto));
    }
}
