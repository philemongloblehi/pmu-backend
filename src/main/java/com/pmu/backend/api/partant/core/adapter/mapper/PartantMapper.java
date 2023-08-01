package com.pmu.backend.api.partant.core.adapter.mapper;

import com.pmu.backend.api.course.core.adapter.mapper.CourseMapper;
import com.pmu.backend.api.partant.core.adapter.model.PartantDTO;
import com.pmu.backend.api.partant.core.domain.Partant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartantMapper {

    @Autowired
    private CourseMapper courseMapper;

    public PartantDTO entityToDto(Partant partant) {
        if (partant == null) {
            return null;
        }
        return new PartantDTO(
                partant.getId(),
                partant.getName(),
                partant.getNumber(),
                courseMapper.entityToDto(partant.getCourse())
        );
    }

    public Partant dtoToEntity(PartantDTO partantDTO) {
        if (partantDTO == null) {
            return null;
        }
        return new Partant(
                partantDTO.getId(),
                partantDTO.getName(),
                partantDTO.getNumber(),
                courseMapper.dtoToEntity(partantDTO.getCourse())
        );
    }

    public List<PartantDTO> entityListToDtoList(List<Partant> partants) {
        if (partants.isEmpty()) {
            return Collections.emptyList();
        }
        return partants.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
