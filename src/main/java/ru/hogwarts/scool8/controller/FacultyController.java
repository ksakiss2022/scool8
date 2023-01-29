package ru.hogwarts.scool8.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.scool8.model.Faculty;
import ru.hogwarts.scool8.service.FacultyService;

import java.util.Collection;
import java.util.List;

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
    public ResponseEntity<Collection<Faculty>> getAllfacultys() {
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
        return facultyService.getFacultyByColor(color);
    }
}
