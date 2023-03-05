package ru.hogwarts.scool8.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.scool8.model.Student;

import java.util.Collection;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findStudentByAgeEquals(int age);

    Collection<Student> findStudentByAgeBetween(int minAge, int maxAge);

    @Query(value = "SELECT AVG(age) as age FROM Student")
    Integer getAverageAge();

    @Query(value = "SELECT COUNT(*) FROM Student")
    Integer getNumberOfAllStudents();

    @Query(value = "SELECT * from student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> theLastFiveStudents();

    List<Student> getStudentByName(String name);


}
