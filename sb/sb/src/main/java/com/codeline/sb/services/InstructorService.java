package com.codeline.sb.services;

import com.codeline.sb.DTO.InstructorRequested;
import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Department;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import com.codeline.sb.repositories.CourseRepository;
import com.codeline.sb.repositories.DepartmentRepository;
import com.codeline.sb.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//    public Instructor saveInstructor(InstructorRequested instructorDTO) {
//        Instructor instructor = new Instructor();
//        instructor.setName(instructorDTO.getName());
//        instructor.setEmail(instructorDTO.getEmail());
//        instructor.setPhoneNumber(instructorDTO.getPhoneNumber());
//        instructor.setDesignation(instructorDTO.getDesignation());
//
////        Department department = departmentRepository.findById(Integer.valueOf(instructorDTO.getName())).get();
////        System.out.println(department);
////
////        Course course = courseRepository.findById(Integer.valueOf(instructor.getName())).get();
////        System.out.println(course);
//
//        // Fetch related entities by ID
//        Department department = departmentRepository.findById(instructorDTO.getDepartmentId())
//                .orElseThrow(() -> new RuntimeException("Department not found"));
//        Course course = courseRepository.findById(instructorDTO.getCourseId())
//                .orElseThrow(() -> new RuntimeException("Course not found"));
//
//        instructor.setDepartment(department);
//        instructor.setCourse(course);

    /// /        Department department = departmentRepository.findById(Integer.valueOf(instructorDTO.getName())).get();
    /// /        Course course = courseRepository.findById(Integer.valueOf(instructor.getName())).get();
    /// /        System.out.println(department);
    /// /        System.out.println(course);
    /// /        instructor.setDepartment(department);
    /// /        instructor.setCourse(course);
//
//
//        instructor.setCreatedDate(new Date());
//        instructor.setIsActive(Boolean.TRUE);
//
//        return instructorRepository.save(instructor);
//    }
    public Instructor saveInstructor(InstructorRequested instructorDTO) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorDTO.getName());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setPhoneNumber(instructorDTO.getPhoneNumber());
        instructor.setDesignation(instructorDTO.getDesignation());

        // Fetch related entities by ID
        Department department = departmentRepository.findById(instructorDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException(Constants.Not_Found));
        Course course = courseRepository.findById(instructorDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException(Constants.Not_Found));

        instructor.setDepartment(department);
        instructor.setCourse(course);

        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        List<Instructor> activeInstructors = new ArrayList<>();
        if (!instructorRepository.findAll().isEmpty()){
            for (Instructor instructor : instructorRepository.findAll()) {
                if (Boolean.TRUE.equals(instructor.getIsActive())) {
                    activeInstructors.add(instructor);
                }
            }
        } else {
            System.out.println(Constants.No_Data_Found);
        }
        return activeInstructors;
    }

    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id).get();
    }

    public String updateInstructor(Instructor instructor) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(instructor.getId()).get();

        if (existingInstructor != null && existingInstructor.getIsActive()) {
            // Only update fields provided
            //                existingCourse.setName(updateObj.getName());
            //                existingCourse.setHours(updateObj.getHours());
            //                existingCourse.setUpdatedDate(new Date());
            //                existingCourse.setIsActive(Boolean.TRUE);

            existingInstructor.setName(instructor.getName());
            existingInstructor.setEmail(instructor.getEmail());
            existingInstructor.setPhoneNumber(instructor.getPhoneNumber());
            existingInstructor.setDesignation(instructor.getDesignation());
            existingInstructor.setUpdatedDate(new Date());
            existingInstructor.setIsActive(Boolean.TRUE);
//            instructor.setUpdatedDate(new Date());
//            instructor.setIsActive(Boolean.TRUE);
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
