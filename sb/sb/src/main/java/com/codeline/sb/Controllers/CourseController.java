package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.CourseCreateRequested;
import com.codeline.sb.DTOResponse.CourseResponseDTO;
import com.codeline.sb.Entities.Course;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseCreateRequested requestObj) throws Exception{
        CourseCreateRequested.validateCourseCreateRequested(requestObj);
        CourseResponseDTO createdCourse = courseService.saveCourse(requestObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    //add full course with instructor and marks
    @PostMapping("/addFullCourse")
    public ResponseEntity<CourseResponseDTO> addFullCourse(@RequestBody CourseCreateRequested courseRequestDTO) {
        try {
            CourseCreateRequested.validateCourseCreateRequested(courseRequestDTO);
            CourseResponseDTO createdCourse = courseService.createCourseWithRelations(courseRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //display all courses
    @GetMapping("getAllCourses")
    public List<Course> getAll(){
        List<Course> allCourses = courseService.getAllCourses();
        return allCourses;
    }

    //get course by id
    @GetMapping("getCourseById/{id}")
    public ResponseEntity<CourseResponseDTO> getStudent(@PathVariable int id) throws Exception{
        Course course = courseService.getCourseById(id);
        CourseResponseDTO courseResponseDTO = CourseResponseDTO.convertEntityToDTO(course);
        return ResponseEntity.status(HttpStatus.OK).body(courseResponseDTO);
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
