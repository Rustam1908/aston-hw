package org.rusty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(NoSuchStudentException.class)
    public ResponseEntity<String> handleNoSuchStudentException() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
