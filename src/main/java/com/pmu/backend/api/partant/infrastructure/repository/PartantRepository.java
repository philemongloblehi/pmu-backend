package com.pmu.backend.api.partant.infrastructure.repository;

import com.pmu.backend.api.partant.core.domain.Partant;
import com.pmu.backend.api.partant.core.port.IPartantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PartantRepository {
    private final IPartantRepository repository;

    public Partant create(Partant partant) {
        return repository.save(partant);
    }
}
