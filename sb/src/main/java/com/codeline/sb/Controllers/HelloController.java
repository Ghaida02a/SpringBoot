package com.codeline.sb.Controllers;

import com.codeline.sb.Entities.Info;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    private Map<Integer, String> courses = new HashMap<>();
    private int idCounter = 1;

     @GetMapping
    public String nothing() {
        return "Please add a path";
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name){
        if(name==null || name.isEmpty()){
            return "Hello Guest";
        }
        return "Hello " + name;
    }

    @GetMapping("/sum")
    public String sum(@RequestParam int a, @RequestParam int b){
        int sum = a + b;
        return "The sum of " + a + " and " + b + " is " + sum;
    }

    @GetMapping("/info")
    public Info getInfo() {
        return new Info("Ghaida", "Muscat", "Arabic");
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Greetings, " + name + "!";
    }

    @GetMapping("/upper")
    public String upper(@RequestParam String text) {
        return text.toUpperCase();
    }

    @GetMapping("/random")
    public String random() {
        int randomNum = (int)(Math.random() * 100) + 1;
        return "Random number: " + randomNum;
    }

    // Course Endpoints
    @PostMapping("/courses")
    public String createCourse(@RequestParam String courseName) {
         courses.put(idCounter, courseName);
        return "Course " + courseName + " created successfully with ID " + idCounter++;
    }

    @GetMapping("/courses")
    public Map<Integer, String> getAllCourses(){
         return courses;
    }

    @GetMapping("/courses/{id}")
    public String getCourseById(@PathVariable int id) {
        return courses.getOrDefault(id, "Course not found");
    }

    @PutMapping("/courses/{id}&{courseName}")
    public String updateCourse(@PathVariable int id, @PathVariable String courseName) {
        if(courses.containsKey(id)){
            courses.put(id, courseName);
            return "Course ID " + id + " updated to " + courseName;
        } else {
            return "Course not found";
        }
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id) {
        boolean removed = courses.remove(id) != null;
        if(removed){
            return "Course ID " + id + " deleted successfully";
        } else {
            return "Course not found";
        }
    }
}
