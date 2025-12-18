package com.codeline.sb.repositories;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query("SELECT i FROM Instructor i WHERE i.id = :id")
    Instructor getInstructorById(Integer id);

    @Query("SELECT i FROM Instructor i WHERE i.isActive = true")
    List<Instructor> findAllActiveInstructors();
}
