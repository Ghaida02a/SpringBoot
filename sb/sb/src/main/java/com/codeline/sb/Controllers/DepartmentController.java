package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.DepartmentCreateRequested;
import com.codeline.sb.DTOResponse.DepartmentResponseDTO;
import com.codeline.sb.Entities.Department;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@RequestBody DepartmentCreateRequested requestObj){
        DepartmentCreateRequested.validateDepartmentCreateRequested(requestObj);
        DepartmentResponseDTO createdDepartment = departmentService.saveDepartment(requestObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }


    //display all Departments
    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments(){
        List<Department> allDepartments = departmentService.getAllDepartments();
        return allDepartments.stream()
                .map(DepartmentResponseDTO::convertDepartmentToDepartmentDTO)
                .toList();
    }

    //get Department by id
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    //update Department
    @PutMapping("/{id}")
    public String updateDepartment(@PathVariable int id,@RequestBody Department updateObjFromUser) throws Exception {
        return departmentService.updateDepartment(updateObjFromUser);
    }

    //delete Department by id
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id) throws Exception {
        departmentService.deleteDepartment(id);
        return Constants.Success;
    }
}
