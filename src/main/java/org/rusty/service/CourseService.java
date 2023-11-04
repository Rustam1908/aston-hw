package org.rusty.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.rusty.converter.CourseConverter;
import org.rusty.exception.NoSuchCourseException;
import org.rusty.model.entity.Course;
import org.rusty.model.rest.CourseDTO;
import org.rusty.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseConverter courseConverter;

    public List<CourseDTO> getAllCourses() {
        return courseConverter.convertList(courseRepository.findAll());
    }

    public CourseDTO getCourse(UUID id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            return courseConverter.convertOne(courseOptional.get());
        }
        throw new NoSuchCourseException("No course found by given id.");
    }
}
