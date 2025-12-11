package com.codeline.sb.repositories;

import com.codeline.sb.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a WHERE a.id = :id")
    Address getAddressById(Integer id);

    @Query("SELECT a FROM Address a WHERE a.student.id = :studentId AND a.isActive = true")
    Address getAddressByStudentId(Integer studentId);
}
