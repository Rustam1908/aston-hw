package org.rusty.exception;

public class NoSuchStudentException extends RuntimeException {

    public NoSuchStudentException(String message) {
        super(message);
    }
}
