package com.codeline.sb.services;

import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.repositories.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InstructorService {
    @Autowired
    InstructorRepo instructorRepo;

    public Instructor saveInstructor(Instructor instructor) {
        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);
        return instructorRepo.save(instructor);
    }
}
