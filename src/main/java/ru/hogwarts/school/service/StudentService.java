package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }


    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }
    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }
    public List<Student> addStudent(String inName, int inAge) {
        Student inStudent = new Student(0L, inName, inAge, null);
        studentRepository.save(inStudent);
        return studentRepository.findByNameAndAge(inName, inAge);
    }

    public Student updateStudent(Long setID, String inName, int inAge) {
        Student student = studentRepository.findById(setID).orElseThrow();
        student.setName(inName);
        student.setAge(inAge);
        studentRepository.save(student);
        return student;
    }
    public Student setFaculty(Long setID, String nameFaculty) {
        Faculty faculty = facultyRepository.findByName(nameFaculty).get(0);
        Student student = studentRepository.findById(setID).orElseThrow();
        student.setFaculty(faculty);
        studentRepository.save(student);
        return student;
    }
    public Student remove(Long remID) {
        Student retStud = studentRepository.findById(remID).orElseThrow();
        studentRepository.deleteById(remID);
        return retStud;
    }

    public List<Student> fineStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public List<Student> fineStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentAge(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge,maxAge);
    }

    public Faculty getFacultyStudent(Long stID) {
        Optional<Student> student = studentRepository.findById(stID);
        return student.orElseThrow().getFaculty();
    }
}
