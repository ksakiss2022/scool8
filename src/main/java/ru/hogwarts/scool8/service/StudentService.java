package ru.hogwarts.scool8.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student student) {
      return studentRepository.save(student);
    }
    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
//getId зачеркнут
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deletStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentByAge(int perAge) {
        return studentRepository.findByAge(perAge);
    }
}
