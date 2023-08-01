package com.pmu.backend.api.course.core.adapter.mapper;

import com.pmu.backend.api.course.core.adapter.model.CourseDTO;
import com.pmu.backend.api.course.core.domain.Course;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {
    public CourseDTO entityToDto(Course course) {
        if (course == null) {
            return null;
        }
        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getNumber(),
                course.getDate(),
                course.getPartants()
        );
    }

    public Course dtoToEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }
        return new Course(
                courseDTO.getId(),
                courseDTO.getName(),
                courseDTO.getNumber(),
                courseDTO.getDate(),
                courseDTO.getPartants()
        );
    }

    public List<CourseDTO> entityListToDtoList(List<Course> courses) {
        if (courses.isEmpty()) {
            return Collections.emptyList();
        }
        return courses.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
