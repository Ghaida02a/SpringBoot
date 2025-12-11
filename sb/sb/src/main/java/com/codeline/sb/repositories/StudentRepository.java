package com.codeline.sb.repositories;

import com.codeline.sb.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.id = :id AND s.isActive = true")
    Student getStudentById(Integer id);

    @Query("SELECT s FROM Student s WHERE s.isActive = true")
    List<Student> findAllActiveStudents();
}
