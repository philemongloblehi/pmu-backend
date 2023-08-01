package com.pmu.backend.api.course.core.service;

import com.pmu.backend.api.course.core.adapter.mapper.CourseMapper;
import com.pmu.backend.api.course.core.adapter.model.CourseDTO;
import com.pmu.backend.api.course.core.domain.Course;
import com.pmu.backend.api.course.core.port.ICourseService;
import com.pmu.backend.api.course.infrastructure.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper mapper;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public CourseDTO create(CourseDTO courseDTO) {
        Course entity = mapper.dtoToEntity(courseDTO);
        Course savedCourse = courseRepository.create(entity);
        kafkaTemplate.send("course-created", "Course with ID " + savedCourse.getId() + " created.");
        return mapper.entityToDto(savedCourse);
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        return mapper.entityListToDtoList(courses);
    }

    @Override
    public CourseDTO findById(Long id) {
        Course course = courseRepository.findById(id);
        return mapper.entityToDto(course);
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        Course course = mapper.dtoToEntity(courseDTO);
        Course updatedCourse = courseRepository.create(course);
        return mapper.entityToDto(updatedCourse);
    }

    @Override
    public void deleteById(Long id) {
        Course course = courseRepository.findById(id);
        if (nonNull(course)) {
            courseRepository.deleteById(id);
        }
    }
}
