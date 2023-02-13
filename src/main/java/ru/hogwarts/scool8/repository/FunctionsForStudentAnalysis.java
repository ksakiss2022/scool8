package ru.hogwarts.scool8.repository;

import ru.hogwarts.scool8.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.ListResourceBundle;

public interface FunctionsForStudentAnalysis {
    Integer averageAge();

    Integer numberOfAllStudents();

    List<Student> theLastFiveStudents();
}
