package com.pmu.backend.api.partant.core.adapter.model;

import com.pmu.backend.api.course.core.adapter.model.CourseDTO;
import com.pmu.backend.api.course.core.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PartantDTO {
    private Long id;
    private String name;
    private String number;
    private CourseDTO course;
}
