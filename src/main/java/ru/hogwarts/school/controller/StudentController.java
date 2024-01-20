package ru.hogwarts.school.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/get/{getID}/faculty")
    public Faculty getFacultyStudent(@PathVariable("getID") String id) {
        return studentService.getFacultyStudent(Long.parseLong(id));
    }
    @GetMapping("/get")
    public List<Student> getStudent() {
        return studentService.getStudentAll();
    }

    @GetMapping("/age/{minAge}-{maxAge}")
    public List<Student>  getStudent(@PathVariable("minAge") int minAge,
                                           @PathVariable("maxAge") int maxAge) {
        return studentService.getStudentAge(minAge,maxAge);
    }
    @GetMapping("/fine/{age}")
    public List<Student> fineStudentAge(@PathVariable("age") String age) {
        return studentService.fineStudentByAge(Integer.parseInt(age));
    }
    @GetMapping("/fine/{name}")
    public List<Student> fineStudentName(@PathVariable("name") String name) {
        return studentService.fineStudentByName(name);
    }
    @PostMapping("/new")
    public List<Student> createStudent(@RequestBody @NotNull
                                                 Map<String,String> data) {
        return studentService.addStudent(data.get("name"),
                                            Integer.parseInt(data.get("age")));
    }

    @PutMapping("/set/faculty")
    public Student setFaculty(@RequestBody Map<String,String> data) {
        return studentService.setFaculty(Long.valueOf(data.get("student_ID")),
                                            data.get("nameFaculty"));
    }

    @PutMapping("/update/{updateID}")
    public Student updateStudent(@PathVariable("updateID") String id,
                                 @RequestBody Map<String,String> data) {
        return studentService.updateStudent(Long.valueOf(id),
                data.get("name"),Integer.parseInt(data.get("age")));
    }
    @PostMapping("/remove")
    public Student removeStudent(@RequestBody @NotNull Long Student_ID) {
        return studentService.remove(Student_ID);
    }
}
