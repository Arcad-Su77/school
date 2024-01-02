package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

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
    @PostMapping("/new")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty.getName(), faculty.getColor());
    }
    @PutMapping("/update/{updateID}")
    public Faculty updateFaculty(@PathVariable("updateID") String id,
                                 @RequestBody String name,
                                 @RequestBody String color) {
        return facultyService.updateFaculty(Long.valueOf(id),
                name,color);
    }
    @PostMapping("/remove")
    public Faculty removeFaculty(@RequestBody Faculty faculty) {
        return facultyService.remove(faculty.getId());
    }
}
