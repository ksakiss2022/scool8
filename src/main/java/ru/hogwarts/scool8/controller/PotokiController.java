package ru.hogwarts.scool8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.service.PotokiService;


@RestController
@RequestMapping("/potoki")
public class PotokiController {
    private final PotokiService potokiService;

    public PotokiController(PotokiService potokiService) {
        this.potokiService = potokiService;
    }

//    @GetMapping("/printStudents") //GET http://localhost:8080/potoki/printStudents
//    public  void printStudents() {
//        potokiService.printStudents();
//    }

    @GetMapping("/printStudents") //GET http://localhost:8080/potoki/printStudents
    public void printStudents() throws InstantiationException, IllegalAccessException {
        potokiService.printStudents();
    }

    @GetMapping("/printStudentsNotSync") //GET http://localhost:8080/potoki/printStudentsNotSync
    public void printStudentsNotSync() {
        potokiService.printStudentsNotSync();
    }

}
