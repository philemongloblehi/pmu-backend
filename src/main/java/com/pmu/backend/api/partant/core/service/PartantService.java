package com.pmu.backend.api.partant.core.service;

import com.pmu.backend.api.partant.core.adapter.mapper.PartantMapper;
import com.pmu.backend.api.partant.core.adapter.model.PartantDTO;
import com.pmu.backend.api.partant.core.domain.Partant;
import com.pmu.backend.api.partant.core.port.IParantService;
import com.pmu.backend.api.partant.infrastructure.repository.PartantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartantService implements IParantService {
    private final PartantRepository partantRepository;
    private final PartantMapper mapper;
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public PartantDTO create(PartantDTO partantDTO) {
        Partant entity = mapper.dtoToEntity(partantDTO);
        Partant savedPartant = partantRepository.create(entity);
        kafkaTemplate.send("partant-created", "Partant with ID " + savedPartant.getId() + " created for Course with ID " + partantDTO.getCourse().getId());
        return mapper.entityToDto(savedPartant);
    }
}
