package ru.hogwarts.school.model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Student {
    private Long id;
    private String name;
    private int age;

    public Student(){
    }

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
