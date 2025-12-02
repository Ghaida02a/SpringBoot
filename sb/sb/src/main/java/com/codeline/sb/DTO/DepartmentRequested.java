package com.codeline.sb.DTO;

import com.codeline.sb.Entities.Department;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentRequested {
    @NotBlank(message = "Department name is required")
    String name;

    //convert DTO to Entity
    public static Department convertDTOToEntity(DepartmentRequested dto) {
        if (dto == null) {
            return null;
        }
        return Department.builder()
                .name(dto.getName())
                .build();
    }

    //convert Entity to DTO
    public static DepartmentRequested convertEntityToDTO(Department entity) {
        if (entity == null) {
            return null;
        }
        return DepartmentRequested.builder()
                .name(entity.getName())
                .build();
    }
}
