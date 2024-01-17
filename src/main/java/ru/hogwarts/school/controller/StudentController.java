package ru.hogwarts.school.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

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

    @GetMapping("/age/{minAge}-{maxAge}")
    public Collection<Student>  getStudent(@PathVariable("minAge") int minAge,
                              @PathVariable("maxAge") int maxAge) {
        return studentService.getStudentAge(minAge,maxAge);
    }
    @GetMapping("/fine/{age}")
    public Collection<Student> fineStudentAge(@PathVariable("age") String age) {
        return studentService.fineStudentByAge(Integer.parseInt(age));
    }
    @GetMapping("/fine/{name}")
    public Collection<Student> fineStudentName(@PathVariable("name") String name) {
        return studentService.fineStudentByName(name);
    }
    @PostMapping("/new")
    public Collection<Student> createStudent(@RequestBody @NotNull String name,
                                             int age) {
        return studentService.addStudent(name, age);
    }
    @PutMapping("/update/{updateID}")
    public Student updateStudent(@PathVariable("updateID") String id,
                                 @RequestBody String name,
                                 @RequestBody String age) {
        return studentService.updateStudent(Long.valueOf(id),
                name,Integer.parseInt(age));
    }
    @PostMapping("/remove")
    public Student removeStudent(@RequestBody @NotNull Student Student) {
        return studentService.remove(Student.getId());
    }
}
