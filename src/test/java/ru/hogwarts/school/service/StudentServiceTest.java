package ru.hogwarts.school.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService.addStudent("St_test1", 18);
        studentService.addStudent("St_test2", 20);
        studentService.addStudent("St_test3", 22);
    }

    @Test
    void getStudent() {
        Student student = studentService.getStudent(1L);
        Student actual = new Student(1L, "St_test1", 18);
        assertEquals(student,actual);
    }

    @Test
    void addStudent() {
        Student student = studentService.addStudent("St_test4", 25);
        Student actual = new Student(4L, "St_test4", 25);
        assertEquals(student, actual);
    }

    @Test
    void updateStudent() {
        Student updatedStudent = studentService.updateStudent(1L, "St_test1_updated", 20);
        Student actual = new Student(1L, "St_test1_updated", 20);
        assertEquals(updatedStudent, actual);
    }

    @Test
    void testUpdateStudent() {
    }

    @Test
    void remove() {
        studentService.remove(1L);
        assertNull(studentService.getStudent(1L));
    }

    @Test
    void getStudentAll() {
        ArrayList<Student> students = studentService.getStudentAll();
        assertEquals(3, students.size());
    }

    @Test
    void fineStudentByAge() {
        studentService.addStudent("St_test5", 18);
        Object[] students = studentService.fineStudentByAge(18);
        assertEquals(2, students.length);

    }
}