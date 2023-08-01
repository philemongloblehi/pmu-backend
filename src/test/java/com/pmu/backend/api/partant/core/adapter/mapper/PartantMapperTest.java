package com.pmu.backend.api.partant.core.adapter.mapper;

import com.pmu.backend.api.course.core.adapter.mapper.CourseMapper;
import com.pmu.backend.api.course.core.adapter.model.CourseDTO;
import com.pmu.backend.api.course.core.domain.Course;
import com.pmu.backend.api.partant.core.adapter.model.PartantDTO;
import com.pmu.backend.api.partant.core.domain.Partant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PartantMapperTest {
    @Mock
    private CourseMapper courseMapper;

    @InjectMocks
    private PartantMapper partantMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testEntityToDtoWithNullPartant() {
        PartantDTO result = partantMapper.entityToDto(null);

        assertNull(result);
    }

    @Test
    void testEntityToDtoWithValidPartant() {
        Partant partant = new Partant(1L, "Horse", "P-001", new Course());

        PartantDTO result = partantMapper.entityToDto(partant);

        assertEquals(partant.getId(), result.getId());
        assertEquals(partant.getName(), result.getName());
        assertEquals(partant.getNumber(), result.getNumber());
    }

    @Test
    void testDtoToEntityWithNullPartantDTO() {
        Partant result = partantMapper.dtoToEntity(null);

        assertNull(result);
    }

    @Test
    void testDtoToEntityWithValidPartantDTO() {
        PartantDTO partantDTO = new PartantDTO(1L, "Horse", "P-001", new CourseDTO());

        Partant result = partantMapper.dtoToEntity(partantDTO);

        assertEquals(partantDTO.getId(), result.getId());
        assertEquals(partantDTO.getName(), result.getName());
        assertEquals(partantDTO.getNumber(), result.getNumber());
    }

    @Test
    void testEntityListToDtoListWithEmptyList() {
        List<Partant> partants = Collections.emptyList();

        List<PartantDTO> result = partantMapper.entityListToDtoList(partants);

        assertEquals(0, result.size());
    }

    @Test
    void testEntityListToDtoListWithValidPartants() {
        List<Partant> partants = Arrays.asList(
                new Partant(1L, "Horse1", "P-001", new Course()),
                new Partant(2L, "Horse2", "P-001", new Course())
        );

        List<PartantDTO> result = partantMapper.entityListToDtoList(partants);

        assertEquals(partants.size(), result.size());
    }
}
