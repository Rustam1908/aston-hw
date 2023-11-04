package org.rusty.service;

import lombok.RequiredArgsConstructor;
import org.rusty.converter.TeacherConverter;
import org.rusty.exception.NoSuchTeacherException;
import org.rusty.model.entity.Teacher;
import org.rusty.model.rest.TeacherDTO;
import org.rusty.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherConverter teacherConverter;

    public List<TeacherDTO> getAllTeachers() {
        return teacherConverter.convertList(teacherRepository.findAll());
    }

    public TeacherDTO getTeacher(UUID id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            return teacherConverter.convertOne(teacherOptional.get());
        }
        throw new NoSuchTeacherException("No teacher found by given id.");
    }
}
