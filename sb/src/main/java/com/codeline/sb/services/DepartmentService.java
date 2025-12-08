package com.codeline.sb.services;

import com.codeline.sb.DTORequest.DepartmentRequested;
import com.codeline.sb.Entities.Department;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(DepartmentRequested departmentDTO) {
        Department department = DepartmentRequested.convertDTOToEntity(departmentDTO);
        department.setCreatedDate(new Date());
        department.setIsActive(Boolean.TRUE);
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        List<Department> activeDepartments = new ArrayList<>();
        if (!departmentRepository.findAll().isEmpty()) {
            for (Department department : departmentRepository.findAll()) {
                if (Boolean.TRUE.equals(department.getIsActive())) {
                    activeDepartments.add(department);
                }
            }
        }
        else {
            System.out.println(Constants.No_Data_Found);
        }
        return activeDepartments;
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).get();
    }

    public String updateDepartment(Department department) throws Exception {
        Department existingDepartment = departmentRepository.findById(department.getId()).get();

        if (existingDepartment != null && existingDepartment.getIsActive()) {

            existingDepartment.setName(department.getName());
            existingDepartment.setUpdatedDate(new Date());
            existingDepartment.setIsActive(Boolean.TRUE);
//            department.setUpdatedDate(new Date());
//            department.setIsActive(Boolean.TRUE);
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
