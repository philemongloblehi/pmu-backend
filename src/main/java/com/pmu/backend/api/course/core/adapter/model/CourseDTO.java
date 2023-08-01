package com.pmu.backend.api.course.core.adapter.model;

import com.pmu.backend.api.partant.core.domain.Partant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDTO {
    private Long id;
    private String name;
    private String date;
    private String number;
    private List<Partant> partants;
}
