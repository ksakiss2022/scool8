package ru.hogwarts.scool8.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.scool8.model.Faculty;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.service.StudentService;

import java.util.Collection;


@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping //POST http://localhost:8080/students
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{id}") //GET http://localhost:8080/students
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping //GET http://localhost:8080/students
    public ResponseEntity<Collection<Student>> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping //PUT http://localhost:8080/students
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}") //DELETE http://localhost:8080/students/23
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deletStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/age/{age}") //GET http://localhost:8080/student/age/22
    public Collection<Student> getStudentByAge(@PathVariable int age) {
        return studentService.findStudentByAge(age);
    }

    @GetMapping("finde-students") //GET http://localhost:8080/student/finde-students
    public Collection<Student> findStudentByMinAgeAndMaxAge(@RequestParam int minAge, @RequestParam int maxAge) {
        return studentService.findStudentByAgeBetween(minAge, maxAge);
    }

    @GetMapping("students-faculty/{id}") //GET http://localhost:8080/student/finde-faculty-by-students-id
    public Faculty getFaculty(@PathVariable Long id) {
        return studentService.getFaculty(id);
    }
}
