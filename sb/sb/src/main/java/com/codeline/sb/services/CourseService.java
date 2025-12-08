package com.codeline.sb.services;

import com.codeline.sb.DTORequest.CourseCreateRequested;
import com.codeline.sb.DTOResponse.CourseResponseDTO;
import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Department;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Entities.Mark;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import com.codeline.sb.repositories.CourseRepository;
import com.codeline.sb.repositories.DepartmentRepository;
import com.codeline.sb.repositories.InstructorRepository;
import com.codeline.sb.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    // Get all active courses
    public List<Course> getAllCourses() {
//        List<Course> activeCourses = new ArrayList<>();
//        List<Course> allCourses = courseRepository.findAll();
//
//        if (!allCourses.isEmpty()) {
//            for (Course course : allCourses) {
//                if (Boolean.TRUE.equals(course.getIsActive())) {
//                    activeCourses.add(course);
//                }
//            }
//        } else {
//            System.out.println(Constants.No_Data_Found);
//        }
//        return activeCourses;
        return courseRepository.findAllActiveCourses();
    }

    public CourseResponseDTO saveCourse(CourseCreateRequested courseRequested){
        Course course = CourseCreateRequested.convertDTOToEntity(courseRequested);
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);

        Instructor instructor = instructorRepository.getInstructorById(courseRequested.getInstructorId());
        if (Utils.isNotNull(instructor)) {
            course.setInstructor(instructor);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        List<Mark> marks = markRepository.findAllMarksByIds(courseRequested.getMarks());
        if (Utils.isNotNull(marks) && !marks.isEmpty()) {
            course.setMarks(marks);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.COURSE_CREATE_REQUEST_MARKS_NOT_VALID);
        }

        return CourseResponseDTO.entityToDTOResponse(courseRepository.save(course));
    }

    //Get course by ID
    public Course getCourseById(int id) throws Exception {
        Course courseOpt = courseRepository.getCourseById(id);
        if (Utils.isNotNull(courseOpt)) {
            return courseOpt;
        } else {
            throw new Exception(Constants.Not_Found);
        }
    }

    // Update course safely
    public String updateCourse(Course updateObj) throws Exception {
        Optional<Course> existingOpt = courseRepository.findById(updateObj.getId());

        if (existingOpt.isPresent()) {
            Course existingCourse = existingOpt.get();

            if (Boolean.TRUE.equals(existingCourse.getIsActive())) {
                // Only update fields provided
                existingCourse.setName(updateObj.getName());
                existingCourse.setHours(updateObj.getHours());
                existingCourse.setUpdatedDate(new Date());
                existingCourse.setIsActive(Boolean.TRUE);

                courseRepository.save(existingCourse);
                return Constants.Success;
            } else {
                throw new Exception(Constants.Bad_Request);
            }
        } else {
            throw new Exception(Constants.Not_Found);
        }
    }

    //Soft delete course
    public void deleteCourse(Integer id) throws Exception {
        Course existingOpt = courseRepository.getCourseById(id);

        if (Utils.isNotNull(existingOpt)) {
                existingOpt.setUpdatedDate(new Date());
                existingOpt.setIsActive(Boolean.FALSE);
                courseRepository.save(existingOpt);
        } else {
            throw new Exception(Constants.Not_Found);
        }
    }

    public CourseResponseDTO createCourseWithRelations(CourseCreateRequested courseRequested) {
        Course course = CourseCreateRequested.convertDTOToEntity(courseRequested);
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);

        Instructor instructor = instructorRepository.getInstructorById(courseRequested.getInstructorId());
        //if instructor not found, create new instructor
        if (Utils.isNull(instructor)) {
            Instructor newInstructor = new Instructor();
            newInstructor.setName(courseRequested.getName());
            newInstructor.setCreatedDate(new Date());
            newInstructor.setIsActive(Boolean.TRUE);

            // Department, check if exists, else create new
            Department department = departmentRepository.getDepartmentById(courseRequested.getDepartmentId());
            if (Utils.isNull(department)) {
                Department newDepartment = new Department();
                newDepartment.setName(courseRequested.getName());
                newDepartment.setCreatedDate(new Date());
                newDepartment.setIsActive(Boolean.TRUE);
                department = departmentRepository.save(newDepartment);
            }
            newInstructor.setDepartment(department);

            instructor = instructorRepository.save(newInstructor);
        }
        // set instructor to course, whether existing or newly created
        course.setInstructor(instructor);

        List<Mark> marks = markRepository.findAllMarksByIds(courseRequested.getMarks());
        if (Utils.isNotNull(marks) && !marks.isEmpty()) {
            course.setMarks(marks);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.COURSE_CREATE_REQUEST_MARKS_NOT_VALID);
        }
        Course savedCourse = courseRepository.save(course);

        return CourseResponseDTO.entityToDTOResponse(savedCourse);
    }
}
