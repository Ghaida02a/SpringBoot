package com.codeline.sb.services;

import com.codeline.sb.Entities.Department;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.repositories.DepartmentRepository;
import com.codeline.sb.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        department.setCreatedDate(new Date());
        department.setIsActive(Boolean.TRUE);
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).get();
    }

    public String updateDepartment(Department department) throws Exception {
        Department existingDepartment = departmentRepository.findById(department.getId()).get();

        if (existingDepartment != null && existingDepartment.getIsActive()) {
            department.setUpdatedDate(new Date());
            department.setIsActive(Boolean.TRUE);
            departmentRepository.save(department);
            return Constants.Success;
        } else {
            throw new Exception(Constants.Bad_Request);
        }
    }

    public void deleteDepartment(Integer id) throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            existingDepartment.setUpdatedDate(new Date());
            existingDepartment.setIsActive(Boolean.FALSE);
            departmentRepository.save(existingDepartment);
        } else {
            throw new Exception("BAD REQUEST");
        }
    }
}
