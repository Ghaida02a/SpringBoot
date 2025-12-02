package com.codeline.sb.services;

import com.codeline.sb.DTO.InstructorRequested;
import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Department;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.repositories.CourseRepository;
import com.codeline.sb.repositories.DepartmentRepository;
import com.codeline.sb.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CourseRepository courseRepository;

    public Instructor saveInstructor(InstructorRequested instructorDTO) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorDTO.getName());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setPhoneNumber(instructorDTO.getPhoneNumber());
        instructor.setDesignation(instructor.getDesignation());

//        Department department = departmentRepository.findById(Integer.valueOf(instructorDTO.getName())).get();
//        System.out.println(department);
//
//        Course course = courseRepository.findById(Integer.valueOf(instructor.getName())).get();
//        System.out.println(course);
        Department department = departmentRepository.findById(Integer.valueOf(instructorDTO.getName())).get();
        Course course = courseRepository.findById(Integer.valueOf(instructor.getName())).get();
        System.out.println(department);
        System.out.println(course);
        instructor.setDepartment(department);
        instructor.setCourse(course);

        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id).get();
    }

    public String updateInstructor(Instructor instructor) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(instructor.getId()).get();

        if (existingInstructor != null && existingInstructor.getIsActive()) {
            instructor.setUpdatedDate(new Date());
            instructor.setIsActive(Boolean.TRUE);
            instructorRepository.save(instructor);
            return Constants.Success;
        } else {
            throw new Exception(Constants.Bad_Request);
        }
    }

    public void deleteInstructor(Integer id) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdatedDate(new Date());
            existingInstructor.setIsActive(Boolean.FALSE);
            instructorRepository.save(existingInstructor);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
