package ru.hogwarts.scool8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
public class FunctionsForStudentAnalysisController {
    private final StudentService studentService;

    public FunctionsForStudentAnalysisController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/students-avarage-age")
    public Integer getAverageAge(){
        return studentService.averageAge();
    }

    @GetMapping("/students-number-all")
    public Integer getNumberOfAllStudents(){
        return studentService.numberOfAllStudents();
    }

    @GetMapping("/students-last-5-students")
    public Collection<Student> getTheLastFiveStudents(){
        return studentService.theLastFiveStudents();
    }

}
