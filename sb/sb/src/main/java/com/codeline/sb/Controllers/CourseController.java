package com.codeline.sb.Controllers;

import com.codeline.sb.Entities.Course;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {
    private List<Course> courseList = new ArrayList<>();
    private int idCounter = 1;

    //create course
    @PostMapping("create")
    public String createCourse(@RequestBody Course requestObj){
        requestObj.setId(idCounter);
        requestObj.setCreatedDate(new Date());
        requestObj.setIsActive(true);

        courseList.add(requestObj);
        return "Course created with ID: " + idCounter++;
    }

    //display all courses
    @GetMapping("getAll")
    public List<Course> getAll(){
        List<Course> activeCourses = new ArrayList<>();
        for (Course course: courseList){
            if(course.getIsActive()){
                activeCourses.add(course);
            }
        }
        System.out.println("All Courses: ");
        return activeCourses;
    }

    //get course by id
    @GetMapping("getCourseById/{id}")
    public Course getStudent(@PathVariable int id) {
        for (Course s : courseList) {
            if (s.getId() == id && s.getIsActive()) {
                return s;
            }
        }
        return Course.builder().build();
    }

    //update course by id
    @PutMapping("updateCourse")
    public String updateCourse(@RequestBody Course updateCourse){
        if (checkIfIdExists(updateCourse.getId()).getId() != -1) {

            Course existingCourse = checkIfIdExists(updateCourse.getId());

            //to update, remove the existing obj from list
            courseList.remove(existingCourse);

            //set updates for the new obj
            existingCourse.setName(updateCourse.getName());
            existingCourse.setUpdatedDate(new Date());

            //save it to course list
            courseList.add(existingCourse);
            return "Course updated successfully!";
        }
        return "Course not found";
    }

    //delete course by id
    @DeleteMapping("deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id){
        if (checkIfIdExists(id).getId() != -1) {
            Course existingCourse = checkIfIdExists(id);
            existingCourse.setIsActive(false);
            return "Course deleted successfully!";
        }
    return "Course not found";}

    public Course checkIfIdExists(int id){
        for (Course course: courseList){
            if(course.getId() == id){
                return course; //if id of course is course list
            }
        }
        return Course.builder().id(-1).build(); //if not, put its id -1
    }
}
