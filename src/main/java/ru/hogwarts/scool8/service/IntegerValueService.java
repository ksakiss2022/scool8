package ru.hogwarts.scool8.service;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Service
public class IntegerValueService {
    public int sum () {
        return Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
    }

    public int sumParallelStreams(){
        return Stream.iterate(1,a->a+1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, (a, b) -> a + b);    }
}
