package ru.hogwarts.scool8.service;


import org.springframework.stereotype.Service;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.repository.StudentRepository;

import java.util.List;


@Service
public class PotokiService {
    private final StudentRepository studentRepository;
    public Integer count = 0;
    public Object flag = new Object();

    private String[] metod1() {
        return new String[0];
    }

    public PotokiService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    private void printStudents(int number) {
        List<String> temp = studentRepository
                .findAll().stream()
                .map(Student::getName)
                .toList();
        synchronized (flag) {
            System.out.println(temp.get(number) + "" + count);
            count++;
        }
    }

    public void printStudentsSync() {
//        logger.info
//                ("Was invoked method for display a list of students. " +
//                        "which is printed in different synchronized threads");
        printStudents(1);
        printStudents(2);

        new Thread(() -> {
            printStudents(3);
            printStudents(4);
        }).start();

        new Thread(() -> {
            printStudents(5);
            printStudents(6);
        }).start();
    }


    public void variant2PrintStudents() {
        String[] nameStudent = metod1();

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "" + nameStudent[1] + "" + nameStudent[2]);
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "" + nameStudent[3] + "" + nameStudent[4]);
        });
        System.out.println(Thread.currentThread().getName() + "" + nameStudent[5] + "" + nameStudent[6]);
        thread2.start();
        thread3.start();
    }

    public void variant2printStudentsSync() {
        String[] nameStudent2 = metod1();
        synchronized (flag) {
            System.out.println(Thread.currentThread().getName() + "" + nameStudent2[1] + "" + nameStudent2[2]);
        }
        new Thread(() -> {
            synchronized (flag) {
                System.out.println(Thread.currentThread().getName() + "" + nameStudent2[3] + "" + nameStudent2[4] + "" + ++count);
            }
        }).start();
        new Thread(() -> {
            synchronized (flag) {
                System.out.println(Thread.currentThread().getName() + "" + nameStudent2[5] + "" + nameStudent2[6] + "" + ++count);
            }
        }).start();
    }
}

