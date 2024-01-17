package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }
    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }
    public Collection<Student> addStudent(String inName, int inAge) {
        Student inStudent = new Student(inName, inAge);
        studentRepository.saveAndFlush(inStudent);
        return studentRepository.findByNameAndAge(inName, inAge);
    }
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudent(Long setID, String inName, int inAge) {
        Student student = studentRepository.findById(setID).orElseThrow();
        student.setName(inName);
        student.setAge(inAge);
        studentRepository.save(student);
        return student;
    }
    public Student remove(Long remID) {
        Student retStud = studentRepository.findById(remID).orElseThrow();
        studentRepository.deleteById(remID);
        return retStud;
    }

    public Collection<Student> fineStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> fineStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public Collection<Student> getStudentAge(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge,maxAge);
    }
}
