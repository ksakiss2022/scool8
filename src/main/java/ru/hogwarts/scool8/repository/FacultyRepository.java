package ru.hogwarts.scool8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scool8.model.Faculty;

import java.util.Collection;


public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findFacultyByNameContainsIgnoreCase(String name);

    Collection<Faculty> findFacultyByColorContainsIgnoreCase(String color);

}
