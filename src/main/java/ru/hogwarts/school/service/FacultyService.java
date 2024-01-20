package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;

@Service
public class FacultyService {
   private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.getReferenceById(id);
    }
    public Faculty addFaculty(String inName, String inColor) {
        Faculty inFaculty = new Faculty();
        inFaculty.setName(inName);
        inFaculty.setColor(inColor);
        return facultyRepository.save(inFaculty);
    }
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Long setID, String inName, String inColor) {
        Faculty faculty = facultyRepository.getReferenceById(setID);
        faculty.setName(inName);
        faculty.setColor(inColor);
        facultyRepository.save(faculty);
        return faculty;
    }
    public Faculty remove(Long remID) {
        Faculty remFac = facultyRepository.getReferenceById(remID);
        facultyRepository.deleteById(remID);
        return remFac;
    }

    public List<Faculty> getFacultyAll() {
        return facultyRepository.findAll();
    }

    public List<Faculty> fineFacultyByName(String name) {
        return facultyRepository.findByName(name);
    }
    public List<Faculty> fineFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public Collection<Student> getStudentFacultyById(Long facID) {
        Faculty faculty = facultyRepository.getReferenceById(facID);
        return faculty.getStudents();

    }
}
