package ru.hogwarts.scool8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scool8.model.Faculty;
import ru.hogwarts.scool8.model.Student;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    List<Faculty> findByColor(String perColor);
}
