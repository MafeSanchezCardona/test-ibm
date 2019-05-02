package com.test.ibm.converter;

import com.test.ibm.dto.AdviserDto;
import com.test.ibm.entity.Adviser;

import java.util.ArrayList;
import java.util.List;

public class AdviserConverter {

    public static Adviser dtoToEntity(AdviserDto adviserDto) {

        Adviser adviser = new Adviser();
        adviser.setIdentification(adviserDto.getIdentification());
        adviser.setName(adviserDto.getName());
        adviser.setSpecialty(adviserDto.getSpecialty());
        return adviser;
    }

    public static List<AdviserDto> entityToDto(List<Adviser> adviserList) {

        List<AdviserDto> adviserDtoList = new ArrayList<>();
        AdviserDto adviserDto;
        for (Adviser adviser : adviserList) {
            adviserDto = new AdviserDto();
            adviserDto.setIdentification(adviser.getIdentification());
            adviserDto.setName(adviser.getName());
            adviserDto.setSpecialty(adviser.getSpecialty());
            adviserDtoList.add(adviserDto);
        }

        return adviserDtoList;
    }
}
