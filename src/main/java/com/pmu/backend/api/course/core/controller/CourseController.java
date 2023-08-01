package com.pmu.backend.api.course.core.controller;

import com.pmu.backend.api.course.core.adapter.model.CourseDTO;
import com.pmu.backend.api.course.core.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO courseDTO) {
        CourseDTO savedCourse = courseService.create(courseDTO);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        List<CourseDTO> courses = courseService.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.findById(id);
        if (isNull(courseDTO)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(courseDTO, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @RequestBody CourseDTO courseRequestDto) {
        CourseDTO courseDTO = courseService.findById(id);
        if (courseDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseRequestDto.setId(id);
        CourseDTO updatedCourseDto = courseService.update(courseRequestDto);
        return new ResponseEntity<>(updatedCourseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        CourseDTO courseExisting = courseService.findById(id);
        if (isNull(courseExisting)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
