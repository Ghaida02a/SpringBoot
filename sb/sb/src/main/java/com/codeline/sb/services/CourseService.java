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

    public String updateCourse(Course course) throws Exception {
        Course existingCourse = courseRepository.findById(course.getId()).get();

        if (existingCourse != null && existingCourse.getIsActive()) {
            course.setUpdatedDate(new Date());
            course.setIsActive(Boolean.TRUE);
            courseRepository.save(course);
            return "Course updated successfully";
        } else {
            throw new Exception("BAD REQUEST");
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
