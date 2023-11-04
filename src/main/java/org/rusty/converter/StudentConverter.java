package org.rusty.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.rusty.model.entity.Student;
import org.rusty.model.rest.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentConverter {

    private final ModelMapper modelMapper;

    public StudentDTO convertOne(Student student){
        return modelMapper.map(student, StudentDTO.class);
    }

    public List<StudentDTO> convertList(List<Student> students){
        return students.stream()
                .map(this::convertOne)
                .collect(Collectors.toList());
    }
}
