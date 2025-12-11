package com.codeline.sb.repositories;

import com.codeline.sb.Entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

    @Query("SELECT pn FROM PhoneNumber pn WHERE pn.id = :id AND pn.isActive = true")
    PhoneNumber getPhoneNumberById(Integer id);

    @Query("SELECT pn FROM PhoneNumber pn WHERE pn.id IN :phoneNumbers")
    List<PhoneNumber> findAllPhoneNumbersByIds(List<String> phoneNumbers);
}
