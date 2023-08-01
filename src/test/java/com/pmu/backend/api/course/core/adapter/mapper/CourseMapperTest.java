package com.pmu.backend.api.course.core.adapter.mapper;

import com.pmu.backend.api.course.core.adapter.model.CourseDTO;
import com.pmu.backend.api.course.core.domain.Course;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.List;

class CourseMapperTest {

    private final CourseMapper courseMapper = new CourseMapper();

    @Test
    void entityToDto_NonNullCourse_ReturnsCourseDTOWithSameAttributes() {
        Course course = new Course(1L, "Sample Course", "2023-08-01", "C001", null);

        CourseDTO courseDTO = courseMapper.entityToDto(course);

        assertNotNull(courseDTO);
        assertEquals(course.getId(), courseDTO.getId());
        assertEquals(course.getName(), courseDTO.getName());
        assertEquals(course.getNumber(), courseDTO.getNumber());
        assertEquals(course.getDate(), courseDTO.getDate());
        assertEquals(course.getPartants(), courseDTO.getPartants());
    }

    @Test
    void entityToDto_NullCourse_ReturnsNull() {
        CourseDTO courseDTO = courseMapper.entityToDto(null);

        assertNull(courseDTO);
    }

    @Test
    void dtoToEntity_NonNullCourseDTO_ReturnsCourseWithSameAttributes() {
        CourseDTO courseDTO = new CourseDTO(1L, "Sample Course", "2023-08-01", "C001", null);

        Course course = courseMapper.dtoToEntity(courseDTO);

        assertNotNull(course);
        assertEquals(courseDTO.getId(), course.getId());
        assertEquals(courseDTO.getName(), course.getName());
        assertEquals(courseDTO.getNumber(), course.getNumber());
        assertEquals(courseDTO.getDate(), course.getDate());
        assertEquals(courseDTO.getPartants(), course.getPartants());
    }

    @Test
    void dtoToEntity_NullCourseDTO_ReturnsNull() {
        Course course = courseMapper.dtoToEntity(null);

        assertNull(course);
    }

    @Test
    void entityListToDtoList_NonEmptyCourseList_ReturnsListOfCourseDTOsWithSameAttributes() {
        List<Course> courses = List.of(new Course(1L, "Course 1", "2023-08-01", "C001", null));

        List<CourseDTO> courseDTOList = courseMapper.entityListToDtoList(courses);

        assertEquals(courses.size(), courseDTOList.size());
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            CourseDTO courseDTO = courseDTOList.get(i);

            assertEquals(course.getId(), courseDTO.getId());
            assertEquals(course.getName(), courseDTO.getName());
            assertEquals(course.getNumber(), courseDTO.getNumber());
            assertEquals(course.getDate(), courseDTO.getDate());
            assertEquals(course.getPartants(), courseDTO.getPartants());
        }
    }

    @Test
    void entityListToDtoList_EmptyCourseList_ReturnsEmptyList() {
        List<Course> courses = Collections.emptyList();

        List<CourseDTO> courseDTOList = courseMapper.entityListToDtoList(courses);

        assertNotNull(courseDTOList);
        assertTrue(courseDTOList.isEmpty());
    }
}

