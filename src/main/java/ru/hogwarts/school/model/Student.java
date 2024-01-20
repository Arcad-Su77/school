package ru.hogwarts.school.model;

import jakarta.persistence.*;
import lombok.Data;
//import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    public Faculty faculty;

    public Student(){}

//    public Student(String name, int age) {
//        this.id = 0L;
//        this.name = name;
//        this.age = age;
////        this.faculty = null;
//    }

    public Student(Long id, String name, int age, Faculty faculty) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
