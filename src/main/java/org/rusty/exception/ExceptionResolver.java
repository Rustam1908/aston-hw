package org.rusty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(NoSuchStudentException.class)
    public ResponseEntity<String> handleNoSuchStudentException() {
        return new ResponseEntity<>("No student found by given id.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchCourseException.class)
    public ResponseEntity<String> handleNoSuchCourseException() {
        return new ResponseEntity<>("No course found by given id.", HttpStatus.BAD_REQUEST);
    }
}
