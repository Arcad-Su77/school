package ru.hogwarts.school.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(@NotNull Long id);

    List<Student> findByAge(int age);

    List<Student> findByName(String name);

    List<Student> findByNameContainsIgnoreCase(String name);

    List<Student> findByNameAndAge(String inName, int inAge);

    @Query()
    List<Student> findByAgeBetween(int minAge, int maxAge);
}
