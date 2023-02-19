package ru.hogwarts.scool8.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.scool8.model.Faculty;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    Logger logger= LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
       logger.debug("Creating a new student:{}",student);
        final var student1 = studentRepository.save(student);
        logger.debug("The Student is{}", student1);
        return student1;
    }

    public Student findStudent(long id) {
        logger.debug("Find a student by id:{}",id);
        final var student = studentRepository.findById(id).get();
        logger.debug("The Student by id is {}",student);
        return student;
    }

    public Student editStudent(Student student) {
        logger.debug("Make changes to the student:{}",student);
        final var save = studentRepository.save(student);
        logger.debug("Сhanged student is {}",save);
        return save;
    }

    public void deletStudent(long id) {
        logger.debug("Delete student:{}",id);
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() {
        logger.debug("We get a list of all students:{}");
        final var all = studentRepository.findAll();
        logger.debug("Collection of all students {}",all);
        return all;

    }


    public Collection<Student> findStudentByAge(int age) {
        logger.debug("Find student by age :{}",age);
        final var studentByAgeEquals = studentRepository.findStudentByAgeEquals(age);
        logger.debug("Collection student by age {}",studentByAgeEquals);
        return studentByAgeEquals;
    }

    public Collection<Student> findStudentByAgeBetween(int minAge, int maxAge) {
        logger.debug("Find student by age between:{}",minAge,maxAge);
        final var studentByAgeBetween = studentRepository.findStudentByAgeBetween(minAge, maxAge);
        logger.debug("Collection student by age between {}",studentByAgeBetween);
        return studentByAgeBetween;
    }

    public Faculty getFaculty(Long id) {
        logger.debug("Get Faculty:{}",id);
        final var faculty = studentRepository.findById(id).get().getFaculty();
        logger.debug("Faculty {}",faculty);
        return faculty;
    }

    public Integer averageAge() {
        logger.debug("Average Age:{}");
        final var averageAge = studentRepository.getAverageAge();
        logger.debug("We output the average age {}",averageAge);
        return averageAge;

    }

    public Integer numberOfAllStudents() {
        logger.debug("Number of all student:{}");
        final var numberOfAllStudents = studentRepository.getNumberOfAllStudents();
        logger.debug("We output the number of all student {}",numberOfAllStudents);
        return numberOfAllStudents;
    }

    public Collection<Student> theLastFiveStudents() {
        logger.debug("The last five students:{}");
        final var students = studentRepository.theLastFiveStudents();
        logger.debug("We output the last five students {}",students);
        return students;
    }

    public List<Student> getStudentByName(String name) {
        logger.debug("Get student by name:{}",name);
        final var studentByName = studentRepository.getStudentByName(name);
        logger.debug("We output the student by name {}",studentByName);
        return studentByName;
    }
}
