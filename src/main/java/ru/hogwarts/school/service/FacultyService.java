package ru.hogwarts.school.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private Long fcoint = 1L;
    Map<Long, Faculty> facultyList;

    public FacultyService() {
        this.facultyList = new HashMap<>();
    }

    @PostConstruct
    private void init(){
        addFaculty("Facultet_1", "Red");
        addFaculty("Facultet_2", "Blue");
        addFaculty("Facultet_3", "Green");
        addFaculty("Facultet_4", "B/W");
    }
    public Faculty getFacultyById(Long id) {
        return facultyList.get(id);
    }
    public Faculty addFaculty(String inName, String inColor) {
        Faculty inFaculty = new Faculty(fcoint++, inName, inColor);
        Faculty resFac = facultyList.putIfAbsent(inFaculty.getId(), inFaculty);
        return (resFac == null) ? inFaculty : resFac;
    }
    public Faculty updateFaculty(Faculty faculty) {
        Faculty resFac = facultyList.putIfAbsent(faculty.getId(), faculty);
        return (resFac == null) ? faculty : resFac;
    }
    public Faculty updateFaculty(Long setID, String inName, String inColor) {
        Faculty faculty = facultyList.get(setID);
        faculty.setName(inName);
        faculty.setColor(inColor);
        facultyList.put(setID, faculty);
        return faculty;
    }
    public Faculty remove(Long remID) {
        Faculty retFac = facultyList.remove(remID);
        if (retFac!=null) fcoint--;
        return retFac;
    }

    public ArrayList<Faculty> getFacultyAll() {
        return new ArrayList<>(facultyList.values());
    }

    public Object[] fineFacultyByColor(String color) {
        return facultyList.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .toArray();
    }
}
