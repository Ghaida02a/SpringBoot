package com.codeline.sb.services;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            System.out.println(Constants.List_Empty);
        } else {
            System.out.println("All Courses:");
        }
        return courses;
    }

    public Course saveCourse(Course course) {
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);
        return courseRepository.save(course);
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    public String updateCourse(Course course) throws Exception {
        Course existingCourse = courseRepository.findById(course.getId()).get();

        if (existingCourse != null && existingCourse.getIsActive()) {
            course.setUpdatedDate(new Date());
            course.setIsActive(Boolean.TRUE);
            courseRepository.save(course);
            return Constants.Success;
        } else {
            throw new Exception(Constants.Bad_Request);
        }
    }

    public void deleteCourse(Integer id) throws Exception {
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            existingCourse.setUpdatedDate(new Date());
            existingCourse.setIsActive(Boolean.FALSE);
            courseRepository.save(existingCourse);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
