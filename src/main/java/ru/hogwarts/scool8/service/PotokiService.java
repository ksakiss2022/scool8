package ru.hogwarts.scool8.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class PotokiService {
    private static final Logger LOG = LoggerFactory.getLogger(PotokiService.class);
    private final StudentRepository studentRepository;

    public PotokiService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void printStudentsNotSync() {
        List<Student> students = studentRepository.findAll(PageRequest.of(0, 6)).getContent();
        printStudentsNotSync(students.subList(0, 2));
        new Thread(() -> printStudentsNotSync(students.subList(2, 4))).start();
        new Thread(() -> printStudentsNotSync(students.subList(4, 6))).start();

    }

    private void printStudentsNotSync(List<Student> students) {
        for (Student student : students) {
            LOG.info(student.getName());
        }
    }

    //        public void printStudents(List<Student> students) {
//        for (Student student : students) {
//            LOG.info(student.getName());
//        }
//    }
//
//    public void printStudents() {
//        List<Student> students = studentRepository.findAll(PageRequest.of(0, 6)).getContent();
//
//        printStudents(students.subList(0, 2));
//        new Thread(() -> printStudents(students.subList(2, 4))).start();
//        new Thread(() -> printStudents(students.subList(4, 6))).start();
//
//    }

    public synchronized void printStudent(Student student) {
        LOG.info(student.getName());
    }


    public void printStudents() throws InstantiationException, IllegalAccessException {
        List<Student> students = studentRepository.getStudentByName(String.valueOf(PageRequest.of(0, 6))).getClass().newInstance();

//        students.add(new Student("Student 1"));
//        students.add(new Student("Student 2"));
//        students.add(new Student("Student 3"));
//        students.add(new Student("Student 4"));
//        students.add(new Student("Student 5"));
//        students.add(new Student("Student 6"));
//        students.add(new Student("Student 7"));


        printStudent((Student) students.subList(0, 2));
        new Thread(() -> printStudent((Student) students.subList(2, 4))).start();
        new Thread(() -> printStudent((Student) students.subList(4, 6))).start();

    }

}


