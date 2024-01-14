package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/get/{getID}")
    public Student getStudent(@PathVariable("getID") String id) {
        return studentService.getStudent(Long.parseLong(id));
    }
    @GetMapping("/get")
    public List<Student> getStudent() {
        return studentService.getStudentAll();
    }
    @GetMapping("/fine/{age}")
    public Optional<Student> fineStudentAge(@PathVariable("age") String age) {
        return studentService.fineStudentByAge(Integer.parseInt(age));
    }
    @GetMapping("/fine/{name}")
    public Optional<Student> fineStudentName(@PathVariable("name") String name) {
        return studentService.fineStudentByName(name);
    }
    @PostMapping("/new")
    public Student createStudent(@RequestBody Student Student) {
        return studentService
                .addStudent(Student.getName(), Student.getAge());
    }
    @PutMapping("/update/{updateID}")
    public Student updateStudent(@PathVariable("updateID") String id,
                                 @RequestBody String name,
                                 @RequestBody String age) {
        return studentService.updateStudent(Long.valueOf(id),
                name,Integer.parseInt(age));
    }
    @PostMapping("/remove")
    public Student removeStudent(@RequestBody Student Student) {
        return studentService.remove(Student.getId());
    }
}
