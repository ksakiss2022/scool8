package ru.hogwarts.scool8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.scool8.service.IntegerValueService;

@RestController
@RequestMapping("/integer")
public class IntegerValueController {
private final IntegerValueService integerValueService;

    public IntegerValueController(IntegerValueService integerValueService) {
        this.integerValueService = integerValueService;
    }

    @GetMapping("/sum")
    public int sum(){
        return integerValueService.sum();
    } @GetMapping("/sumParallelStreams")
    public int sumParallelStreams(){
        return integerValueService.sumParallelStreams();
    }
}
