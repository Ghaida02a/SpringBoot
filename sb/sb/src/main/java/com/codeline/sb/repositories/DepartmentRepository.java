package com.codeline.sb.repositories;

import com.codeline.sb.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {


    @Query("SELECT d FROM Department d WHERE d.id =:id")
    Department getDepartmentById(Integer id);
}
