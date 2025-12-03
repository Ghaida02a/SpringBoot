package com.codeline.sb.services;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    // Get all active courses
    public List<Course> getAllCourses() {
        List<Course> activeCourses = new ArrayList<>();
        List<Course> allCourses = courseRepository.findAll();

        if (!allCourses.isEmpty()) {
            for (Course course : allCourses) {
                if (Boolean.TRUE.equals(course.getIsActive())) {
                    activeCourses.add(course);
                }
            }
        } else {
            System.out.println(Constants.No_Data_Found);
        }
        return activeCourses;
    }

    //Save new course
    public Course saveCourse(Course course) {
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);
        return courseRepository.save(course);
    }

    //Get course by ID
    public Course getCourseById(int id) throws Exception {
        Optional<Course> courseOpt = courseRepository.findById(id);
        if (courseOpt.isPresent()) {
            return courseOpt.get();
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
        Optional<Course> existingOpt = courseRepository.findById(id);

        if (existingOpt.isPresent()) {
            Course existingCourse = existingOpt.get();

            if (Boolean.TRUE.equals(existingCourse.getIsActive())) {
                existingCourse.setUpdatedDate(new Date());
                existingCourse.setIsActive(Boolean.FALSE);
                courseRepository.save(existingCourse);
            } else {
                throw new Exception(Constants.Bad_Request);
            }
        } else {
            throw new Exception(Constants.Not_Found);
        }
    }
}
