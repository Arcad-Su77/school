package ru.hogwarts.school.model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Faculty {
    private Long id;
    private String name;
    private String color;

    public Faculty() {}

    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
