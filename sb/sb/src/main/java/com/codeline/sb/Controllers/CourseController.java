package com.codeline.sb.Controllers;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    //create course
    @PostMapping("/create")
    public String createCourse(@RequestBody Course requestObj){
        Course course = courseService.saveCourse(requestObj);
        return Constants.Success + "Course created with ID: " + course.getId();
    }

    //display all courses
    @GetMapping("getAllCourses")
    public List<Course> getAll(){
        List<Course> allCourses = courseService.getAllCourses();
        return allCourses;
    }

    //get course by id
    @GetMapping("getCourseById/{id}")
    public Course getStudent(@PathVariable int id) throws Exception{
        return courseService.getCourseById(id);
    }

    //update course
    @PutMapping("updateCourse")
    public String updateCourse(@RequestBody Course updateObjFromUser) throws Exception {
        return courseService.updateCourse(updateObjFromUser);
    }

    //delete course by id
    @DeleteMapping("deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id) throws Exception {
        courseService.deleteCourse(id);
        return Constants.Success;
    }
}
