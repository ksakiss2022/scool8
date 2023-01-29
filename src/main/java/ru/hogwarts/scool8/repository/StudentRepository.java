package ru.hogwarts.scool8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scool8.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByAge(int perAge);
}
