package org.rusty.exception;

public class NoSuchCourseException extends RuntimeException {

    public NoSuchCourseException(String message) {
        super(message);
    }
}
