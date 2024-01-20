package ru.hogwarts.school.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private final StudentService studentService;

    StudentServiceTest(StudentService studentService) {
        this.studentService = studentService;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void getStudent() {
        Student student = studentService.getStudent(1L);
        Student actual = new Student(0L, "St_test1", 18, null);
        assertEquals(student,actual);
    }

    @Test
    void addStudent() {
        Student student = studentService.addStudent("St_test4", 25)
                .stream().findFirst().orElseThrow();
        Student actual = new Student(0L,"St_test4", 25,null);
        assertEquals(student, actual);
    }

    @Test
    void updateStudent() {
        Student updatedStudent = studentService.updateStudent(1L, "St_test1_updated", 20);
        Student actual = new Student(0L, "St_test1_updated", 20, null);
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
        List<Student> students = studentService.getStudentAll();
        assertEquals(3, students.size());
    }

    @Test
    void fineStudentByAge() {
        studentService.addStudent("St_test5", 18);
        Collection<Student> students = studentService.fineStudentByAge(18);
        assertEquals(2, students.size());

    }
}