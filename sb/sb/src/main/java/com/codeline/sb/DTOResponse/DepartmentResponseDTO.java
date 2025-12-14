package com.codeline.sb.DTOResponse;

import com.codeline.sb.Entities.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponseDTO {
    private Integer id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;

    //Entity -> DTO response
    public static DepartmentResponseDTO convertDepartmentToDepartmentDTO(Department department){
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setName(department.getName());

        return DepartmentResponseDTO.builder()
                .name(department.getName())
                .createdDate(department.getCreatedDate())
                .updatedDate(department.getUpdatedDate())
                .isActive(department.getIsActive())
                .build();
    }

    //DTO Response -> Entity
    public static Department convertDepartmentDTOToDepartment(DepartmentResponseDTO dto) {
        if (dto == null) {
            return null;
        }

        return Department.builder()
                .id(dto.getId())
                .name(dto.getName())
                .createdDate(dto.getCreatedDate())
                .updatedDate(dto.getUpdatedDate())
                .isActive(dto.getIsActive())
                .build();
    }

}
