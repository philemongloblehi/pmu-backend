package com.pmu.backend.api.partant.core.port;

import com.pmu.backend.api.partant.core.domain.Partant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPartantRepository  extends JpaRepository<Partant, Long> {
}
