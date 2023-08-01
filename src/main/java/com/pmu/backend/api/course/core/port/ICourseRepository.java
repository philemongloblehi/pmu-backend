package com.pmu.backend.api.course.core.port;

import com.pmu.backend.api.course.core.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
