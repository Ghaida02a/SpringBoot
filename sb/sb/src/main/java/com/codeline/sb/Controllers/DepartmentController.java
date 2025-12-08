package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.DepartmentRequested;
import com.codeline.sb.Entities.Department;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/createDepartment")
    public String createDepartment(@RequestBody DepartmentRequested requestObj){
        Department department = departmentService.saveDepartment(requestObj);
        return Constants.Success + "Department created with ID: " + department.getId();
    }


    //display all Departments
    @GetMapping("getAllDepartments")
    public List<Department> getAllDepartments(){
        List<Department> allDepartments = departmentService.getAllDepartments();
        return allDepartments;
    }

    //get Department by id
    @GetMapping("getDepartmentById/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    //update Department
    @PutMapping("updateDepartment")
    public String updateDepartment(@RequestBody Department updateObjFromUser) throws Exception {
        return departmentService.updateDepartment(updateObjFromUser);
    }

    //delete Department by id
    @DeleteMapping("deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable int id) throws Exception {
        departmentService.deleteDepartment(id);
        return Constants.Success;
    }
}
