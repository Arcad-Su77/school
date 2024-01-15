package ru.hogwarts.school.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceTest {
    private FacultyService facultyService;


    @BeforeEach
    void setUp() {
        facultyService = new FacultyService();
        facultyService.addFaculty("name", "color");
        facultyService.addFaculty("name2", "color2");
        facultyService.addFaculty("name3", "color3");

    }

    @Test
    void getFacultyById() {
        Faculty faculty = facultyService.getFacultyById(1L);
        Faculty actual = new Faculty(1L, "name", "color");
        assertEquals(faculty,actual);
    }

    @Test
    void addFaculty() {
        Faculty faculty = facultyService.addFaculty("name4", "color4");
        Faculty actual = new Faculty(4L, "name4", "color4");
        assertEquals(faculty, actual);
    }

    @Test
    void updateFaculty() {
        Faculty faculty = facultyService.updateFaculty(1L, "newName", "newColor");
        Faculty actual = new Faculty(1L, "newName", "newColor");
        assertEquals(faculty, actual);
    }

    @Test
    void testUpdateFaculty() {
        Faculty upFac = new Faculty(1L, "newName", "newColor");
        Faculty oldFac = facultyService.getFacultyById(1L);
        Faculty faculty = facultyService.updateFaculty(upFac);
        assertEquals(faculty, oldFac);
    }

    @Test
    void remove() {
        facultyService.remove(1L);
        assertNull(facultyService.getFacultyById(1L));
    }

    @Test
    void getFacultyAll() {
        ArrayList<Faculty> facultyList = facultyService.getFacultyAll();
        assertEquals(3, facultyList.size());
    }

    @Test
    void fineFacultyByColor() {
        facultyService.addFaculty("test4", "color");
        Object[] faculties = facultyService.fineFacultyByColor("color");
        assertEquals(2, faculties.length);
    }
}