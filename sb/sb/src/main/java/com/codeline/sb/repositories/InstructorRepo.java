package com.codeline.sb.repositories;

import com.codeline.sb.Entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo  extends JpaRepository<Instructor, Integer> {
}
