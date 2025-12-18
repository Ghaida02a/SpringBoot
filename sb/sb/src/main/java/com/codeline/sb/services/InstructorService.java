package com.codeline.sb.services;

import com.codeline.sb.DTORequest.InstructorCreateRequested;
import com.codeline.sb.DTOResponse.InstructorResponseDTO;
import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Department;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import com.codeline.sb.repositories.CourseRepository;
import com.codeline.sb.repositories.DepartmentRepository;
import com.codeline.sb.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public InstructorResponseDTO saveInstructor(InstructorCreateRequested instructorDTO) {
        Instructor instructor = InstructorCreateRequested.convertDTOToEntity(instructorDTO);
        instructor.setName(instructorDTO.getName());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setPhoneNumber(instructorDTO.getPhoneNumber());
        instructor.setDesignation(instructorDTO.getDesignation());

        // Fetch related entities by ID
//        Department department = departmentRepository.findById(instructorDTO.getDepartmentId())
//                .orElseThrow(() -> new RuntimeException(Constants.Not_Found));
//        Course course = courseRepository.findById(instructorDTO.getCourseId())
//                .orElseThrow(() -> new RuntimeException(Constants.Not_Found));
//
//        instructor.setDepartment(department);
//        instructor.setCourse(course);
        Department department = departmentRepository.getDepartmentById(instructorDTO.getDepartmentId());
        if(Utils.isNotNull(department)){
            instructor.setDepartment(department);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INSTRUCTOR_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID);
        }

        Course course = courseRepository.getCourseById(instructorDTO.getCourseId());
        if(Utils.isNotNull(course)){
            instructor.setCourse(course);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INSTRUCTOR_CREATE_REQUEST_COURSE_NOT_VALID);
        }

        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

        return InstructorResponseDTO.convertInstructorToDTOResponse(instructorRepository.save(instructor));
    }

    public List<Instructor> getAllInstructors() {
        if (Utils.isListNotEmpty(instructorRepository.findAllActiveInstructors())) {
            return instructorRepository.findAllActiveInstructors();
        } else {
            return new ArrayList<>();
        }
    }

    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id).get();
    }

    public String updateInstructor(Instructor instructor) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(instructor.getId()).get();

        if (existingInstructor != null && existingInstructor.getIsActive()) {
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
