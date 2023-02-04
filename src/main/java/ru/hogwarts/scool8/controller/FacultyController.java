package ru.hogwarts.scool8.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.scool8.model.Faculty;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("facultys")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}") //GET http://localhost:8080/facultys/3
    public Faculty getFacultyInfo(@PathVariable Long id) {
        return facultyService.findFaculty(id);
    }

    @PostMapping //POST http://localhost:8080/facultys
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping //GET http://localhost:8080/facultys
    public ResponseEntity findFaculty(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String color) {
        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(facultyService.findFacultyByName(name));
        }
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findFacultyByColor(color));
        }
        return ResponseEntity.ok(facultyService.getAllfacultys());
    }

    @PutMapping //PUT http://localhost:8080/facultys
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("{id}") //DELETE http://localhost:8080/facultys/3
    public ResponseEntity deletFaculty(@PathVariable Long id) {
        facultyService.deletFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/color/{color}") //GET http://localhost:8080/facultys/color/blue
    public Collection<Faculty> getFacultyByColor(@PathVariable String color) {
        return facultyService.findFacultyByColor(color);
    }

    @GetMapping("facultys-student/{id}") //GET http://localhost:8080/favultys/finde-students-by-faculty-id
    public Collection<Student> getFacultyStudents(@PathVariable Long id) {
        return facultyService.getFacultyStudents(id);
    }

}
