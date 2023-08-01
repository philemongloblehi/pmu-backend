package com.pmu.backend.api.course.core.port;

import com.pmu.backend.api.course.core.adapter.model.CourseDTO;

import java.util.List;

public interface ICourseService {
    CourseDTO create(CourseDTO courseDTO);
    List<CourseDTO> findAll();
    CourseDTO findById(Long id);
    CourseDTO update(CourseDTO courseDto);
    void deleteById(Long id);
}
