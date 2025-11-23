package com.codeline.sb.services;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);
        return courseRepository.save(course);
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    public Course updateCourse(Course course) throws Exception {
        Course courseToUpdate = courseRepository.findById(course.getId()).get();

        if (courseToUpdate != null && courseToUpdate.getIsActive()) {
            courseToUpdate.setUpdatedDate(new Date());
            return courseRepository.save(courseToUpdate);
        } else {
            throw new Exception("Course not found");
        }
    }

    public String deleteCourse(int id) {
        Course courseToDelete = courseRepository.findById(id).get();

        if (courseToDelete != null && courseToDelete.getIsActive()) {
            courseToDelete.setIsActive(Boolean.FALSE);
            courseRepository.save(courseToDelete);
            return "Course deleted successfully";
        } else {
            return "Course not found";
        }
    }
}
