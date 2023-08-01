package com.pmu.backend.api.partant.core.controller;

import com.pmu.backend.api.course.core.adapter.model.CourseDTO;
import com.pmu.backend.api.course.core.service.CourseService;
import com.pmu.backend.api.partant.core.adapter.model.PartantDTO;
import com.pmu.backend.api.partant.core.service.PartantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/partants")
@RequiredArgsConstructor
public class PartantController {

    private final PartantService partantService;
    private final CourseService courseService;

    @PostMapping("/courses/{courseId}")
    public ResponseEntity<PartantDTO> createPartant(@PathVariable Long courseId, @RequestBody PartantDTO partantDTO) {
        CourseDTO courseDTO = courseService.findById(courseId);
        if (isNull(courseDTO)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        partantDTO.setCourse(courseDTO);
        PartantDTO partantSaved = partantService.create(partantDTO);
        return new ResponseEntity<>(partantSaved, HttpStatus.CREATED);
    }
}
