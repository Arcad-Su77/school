package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.ArrayList;

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
    public ArrayList<Student> getStudent() {
        return studentService.getStudentAll();
    }
    @GetMapping("/fine/{age}")
    public Object[] fineStudent(@PathVariable("age") String age) {
        return studentService.fineStudentByAge(Integer.parseInt(age));
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
