package org.rusty.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.rusty.converter.StudentConverter;
import org.rusty.exception.NoSuchStudentException;
import org.rusty.model.entity.Student;
import org.rusty.model.rest.StudentDTO;
import org.rusty.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    public List<StudentDTO> getAllStudents() {
        return studentConverter.convertList(studentRepository.findAll());
    }

    public StudentDTO getStudent(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            return studentConverter.convertOne(studentOptional.get());
        }
        throw new NoSuchStudentException("No student found by given id.");
    }
}
