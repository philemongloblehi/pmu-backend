package com.pmu.backend.api.partant.core.domain;

import com.pmu.backend.api.course.core.domain.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "partant")
public class Partant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String number;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
