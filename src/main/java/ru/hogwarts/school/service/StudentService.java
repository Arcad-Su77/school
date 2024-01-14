package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

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
    public Student addStudent(String inName, int inAge) {
        Student inStudent = new Student(inName, inAge);
        return studentRepository.save(inStudent);
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

    public Optional<Student> fineStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Optional<Student> fineStudentByName(String name) {
        return studentRepository.findByName(name);
    }

}
