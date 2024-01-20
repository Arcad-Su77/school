package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("/get/{getID}")
    public Faculty getFaculty(@PathVariable("getID") String id) {
        return facultyService.getFacultyById(Long.parseLong(id));
    }

    @GetMapping("/get/{getID}/student")
    public Collection<Student> getStudentFaculty(@PathVariable("getID") String id) {
        return facultyService.getStudentFacultyById(Long.parseLong(id));
    }

    @GetMapping("/get")
    public List<Faculty> getFaculty() {
        return facultyService.getFacultyAll();
    }
    @GetMapping("/fine/{name}")
    public List<Faculty> fineFacultyName(@PathVariable("name") String name) {
        return facultyService.fineFacultyByName(name);
    }
    @GetMapping("/fine/{color}")
    public List<Faculty> fineFacultyColor(@PathVariable("color") String color) {
        return facultyService.fineFacultyByColor(color);
    }
    @PostMapping("/new")
    public Faculty createFaculty(@RequestBody Map<String,String> data) {
        return facultyService.addFaculty(data.get("nameFaculty"), data.get("colorFaculty"));
    }
    @PutMapping("/update/{updateID}")
    public Faculty updateFaculty(@PathVariable("updateID") String id,
                                 @RequestBody Map<String,String> data) {
        return facultyService.updateFaculty(Long.valueOf(id),
                data.get("name"), data.get("color"));
    }
    @PostMapping("/remove")
    public Faculty removeFaculty(@RequestBody Faculty faculty) {
        return facultyService.remove(faculty.getId());
    }
}
