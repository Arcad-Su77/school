package ru.hogwarts.school.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private Long scoint = 1L;
    Map<Long, Student> students;

    public StudentService() {
        this.students = new HashMap<>();
    }

    @PostConstruct
    private void init(){
        addStudent("Student_1", 18);
        addStudent("Student_2", 20);
        addStudent("Student_3", 22);
        addStudent("Student_4", 24);
    }

    public Student getStudent(Long id) {
        return students.get(id);
    }
    public Student addStudent(String inName, int inAge) {
        Student inStudent = new Student(scoint++, inName, inAge);
        return students.putIfAbsent(inStudent.getId(), inStudent);
    }
    public Student updateStudent(Student student) {
        return students.putIfAbsent(student.getId(),student);
    }
    public Student updateStudent(Long setID, String inName, int inAge) {
        Student student = students.get(setID);
        student.setName(inName);
        student.setAge(inAge);
        students.put(setID, student);
        return student;
    }
    public Student remove(Long remID) {
        Student retStud = students.remove(remID);
        if (retStud!=null) scoint--;
        return retStud;
    }

}
