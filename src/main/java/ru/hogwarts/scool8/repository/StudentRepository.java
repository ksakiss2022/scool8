package ru.hogwarts.scool8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.hogwarts.scool8.model.Student;

import java.util.Collection;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findStudentByAgeEquals(int age);

    Collection<Student> findStudentByAgeBetween(int minAge, int maxAge);

}
