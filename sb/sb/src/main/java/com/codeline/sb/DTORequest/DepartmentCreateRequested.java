package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Department;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentCreateRequested {
    private String name;

    //Validation
    public static void validateDepartmentCreateRequested(DepartmentCreateRequested dto){
        if(Utils.isNull(dto.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.DEPARTMENT_NAME);
        }
    }

    //convert DTO to Entity
    public static Department convertDTOToEntity(DepartmentCreateRequested dto) {
        Department department = Department.builder()
                .name(dto.getName())
                .build();
        return department;
    }

    //convert Entity to DTO
    public static DepartmentCreateRequested convertEntityToDTO(Department entity) {
        return DepartmentCreateRequested.builder()
                .name(entity.getName())
                .build();
    }
}
