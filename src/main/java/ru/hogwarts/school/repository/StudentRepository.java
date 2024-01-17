package ru.hogwarts.school.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(@NotNull Long id);

    Collection<Student> findByAge(int age);

    Collection<Student> findByName(String name);

    Collection<Student> findByNameContainsIgnoreCase(String name);

    Collection<Student> findByNameAndAge(String inName, int inAge);

    Collection<Student> findByAgeBetween(int minAge, int maxAge);
}
