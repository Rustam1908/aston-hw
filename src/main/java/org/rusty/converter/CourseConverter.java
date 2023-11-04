package org.rusty.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.rusty.model.entity.Course;
import org.rusty.model.rest.CourseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseConverter {

    private final ModelMapper modelMapper;

    public CourseDTO convertOne(Course course){
        return modelMapper.map(course, CourseDTO.class);
    }

    public List<CourseDTO> convertList(List<Course> courses){
        return courses.stream()
                .map(this::convertOne)
                .collect(Collectors.toList());
    }
}
