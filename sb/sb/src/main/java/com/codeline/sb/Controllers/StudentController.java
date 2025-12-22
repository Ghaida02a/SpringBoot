package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.StudentCreateRequest;
import com.codeline.sb.DTOResponse.StudentCreateResponse;
import com.codeline.sb.Entities.Student;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    //create student
    @PostMapping
    public ResponseEntity<StudentCreateResponse> createStudent(@RequestBody StudentCreateRequest requestObj) throws Exception {
        try {
            StudentCreateRequest.validateStudentCreateRequested(requestObj);
            StudentCreateResponse newStudent = studentService.saveStudent(requestObj);
            return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);        }
    }

    //display all students
    @GetMapping
    public List<StudentCreateResponse> getAll() {
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents.stream()
                .map(StudentCreateResponse::convertStudentToDTO)
                .toList();
    }

    //get Student by id
    @GetMapping("/{id}")
    public StudentCreateResponse getStudent(@PathVariable int id) throws Exception {
        Student student = studentService.getStudentById(id);
        return StudentCreateResponse.convertStudentToDTO(student);
    }

    //update Student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updateObjFromUser) throws Exception {
        return studentService.updateStudent(updateObjFromUser);
    }

    //delete Student by id
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) throws Exception {
        studentService.deleteStudent(id);
        return Constants.STUDENT_DELETED_SUCCESS;
    }
}
