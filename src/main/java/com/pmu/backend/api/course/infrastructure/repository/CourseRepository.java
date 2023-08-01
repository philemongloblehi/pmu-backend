package com.pmu.backend.api.course.infrastructure.repository;

import com.pmu.backend.api.course.core.domain.Course;
import com.pmu.backend.api.course.core.port.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CourseRepository {

    private final ICourseRepository repository;

    public Course create(Course course) {
        return repository.save(course);
    }

    public List<Course> findAll() {
        return repository.findAll();
    }

    public Course findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Course update(Course course) {
        return repository.save(course);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
