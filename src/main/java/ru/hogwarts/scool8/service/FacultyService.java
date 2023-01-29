package ru.hogwarts.scool8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.scool8.model.Faculty;
import ru.hogwarts.scool8.repository.FacultyRepository;
import java.util.Collection;
import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    public Faculty createFaculty(Faculty faculty) {
      return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
//getId зачеркнут
    }
    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    public void deletFaculty(long id) {
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> getAllfacultys() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultyByColor(String perColor) {
        return facultyRepository.findByColor(perColor);
    }
}
