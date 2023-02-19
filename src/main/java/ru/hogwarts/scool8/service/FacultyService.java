package ru.hogwarts.scool8.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.scool8.model.Faculty;
import ru.hogwarts.scool8.model.Student;
import ru.hogwarts.scool8.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;


@Service
public class FacultyService {
    Logger logger= LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.debug("Creating a new faculty:{}",faculty);
        final var save = facultyRepository.save(faculty);
        logger.debug("A new faculty{}", save);
        return save;
    }

    public Faculty findFaculty(long id) {
        logger.debug("Find a faculty by id:{}",id);
        final var faculty = facultyRepository.findById(id).get();
        logger.debug("The faculty by id is{}", faculty);
        return faculty;
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.debug("Edit faculty:{}",faculty);
        final var faculty1 = facultyRepository.save(faculty);
        logger.debug("Faculty (edit) is{}", faculty1);
        return faculty1;
    }

    public void deletFaculty(long id) {
        logger.debug("Delete faculty:{}",id);
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllfacultys() {
        logger.debug("Collection all facultys:{}");
        final var all = facultyRepository.findAll();
        logger.debug("All facultys is{}", all);
        return all;
    }

    public Collection<Faculty> findFacultyByColor(String color) {
        logger.debug("Find faculty by color:{}",color);
        final var facultyByColorContainsIgnoreCase = facultyRepository.findFacultyByColorContainsIgnoreCase(color);
        logger.debug("Faculty by color is{}", facultyByColorContainsIgnoreCase);
        return facultyByColorContainsIgnoreCase;
    }

    public Faculty findFacultyByName(String name) {
        logger.debug("Find faculty by name:{}",name);
        final var facultyByNameContainsIgnoreCase = facultyRepository.findFacultyByNameContainsIgnoreCase(name);
        logger.debug("Faculty by name is{}", facultyByNameContainsIgnoreCase);
        return facultyByNameContainsIgnoreCase;
    }

    public Collection<Student> getFacultyStudents(Long id) {
        logger.debug("Students by faculty id:{}",id);
        final var students = facultyRepository.findById(id).get().getStudents();
        logger.debug("The Students by faculty{}", students);
        return students;
    }
}

