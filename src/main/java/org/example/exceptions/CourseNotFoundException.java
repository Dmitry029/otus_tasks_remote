package org.example.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String courseName) {
        super("Курс с названием \"" + courseName + "\" не найден");
    }
}