package org.rusty.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.rusty.model.entity.Teacher;
import org.rusty.model.rest.TeacherDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeacherConverter {

    private final ModelMapper modelMapper;

    public TeacherDTO convertOne(Teacher teacher){
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    public List<TeacherDTO> convertList(List<Teacher> teachers){
        return teachers.stream()
                .map(this::convertOne)
                .collect(Collectors.toList());
    }
}
