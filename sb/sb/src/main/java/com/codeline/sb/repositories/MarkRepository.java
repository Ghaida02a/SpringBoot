package com.codeline.sb.repositories;

import com.codeline.sb.Entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

    @Query("SELECT m FROM Mark m WHERE m.id IN :markIds")
    List<Mark> findAllMarksByIds(List<String> markIds);

    @Query("SELECT m FROM Mark m WHERE m.isActive = true")
    List<Mark> findAllActiveMarks();
}
