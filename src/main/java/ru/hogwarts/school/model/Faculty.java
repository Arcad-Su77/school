package ru.hogwarts.school.model;

//import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
//import org.springframework.data.annotation.Id;

import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Long id = 0L;

    private String name;
    private String color;

    @OneToMany(mappedBy = "faculty")
    public Collection<Student> students;

    public Faculty() {}

//    public Faculty(String name, String color) {
//        this.name = name;
//        this.color = color;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty faculty)) return false;
        return Objects.equals(name, faculty.name) && Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }

}
