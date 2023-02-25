package ru.hogwarts.scool8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.scool8.service.PotokiService;

@RestController
@RequestMapping("/potoki")
public class PotokiController {
    private final PotokiService potokiService;

    public PotokiController(PotokiService potokiService) {
        this.potokiService = potokiService;
    }

    @GetMapping("/printStudents") //GET http://localhost:8080/potoki/printStudents
    public void printStudents() {
        potokiService.printStudentsSync();
    }

    @GetMapping("/printStudentsSync") //GET http://localhost:8080/potoki/printStudentsSync
    public void printStudentsSync() {
        potokiService.printStudentsSync();
    }

    @GetMapping("/variant2PrintStudents") //GET http://localhost:8080/potoki/variant2PrintStudents
    public void variant2PrintStudents() {
        potokiService.variant2PrintStudents();
    }

    @GetMapping("/variant2printStudentsSync") //GET http://localhost:8080/potoki/variant2printStudentsSync
    public void variant2printStudentsSync() {
        potokiService.variant2printStudentsSync();
    }
}
