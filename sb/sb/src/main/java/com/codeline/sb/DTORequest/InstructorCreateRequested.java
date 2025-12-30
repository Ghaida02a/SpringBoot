package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Exceptions.CustomException;
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
public class InstructorCreateRequested {
    private String name;
    private String email;
    private String phoneNumber;
    private String designation;
    private Integer departmentId;
    private Integer courseId;

    //validation
    public static void validateInstructorRequested(InstructorCreateRequested dto) throws CustomException {
        if (Utils.isNull(dto.getName())) {
            throw new CustomException(Constants.INSTRUCTOR_NAME, Constants.HTTP_STATUS_IS_NULL);
        }
       if(Utils.isNull(dto.getEmail())) {
           throw new CustomException(Constants.INSTRUCTOR_EMAIL, Constants.HTTP_STATUS_IS_NULL);
       }
       if(Utils.isNull(dto.getPhoneNumber())) {
              throw new CustomException(Constants.INSTRUCTOR_PHONE_NUMBER, Constants.HTTP_STATUS_IS_NULL);
       }
       if(Utils.isNull(dto.getDesignation())) {
           throw new CustomException(Constants.INSTRUCTOR_DESIGNATION, Constants.HTTP_STATUS_IS_NULL);
       }
    }

    //convert DTO → Entity
    public static Instructor convertDTOToEntity(InstructorCreateRequested dto) {
        return Instructor.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .designation(dto.getDesignation())
                .build();
    }

    // convert Entity → DTO
    public static InstructorCreateRequested convertEntityToDTO(Instructor entity) {
        return InstructorCreateRequested.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .designation(entity.getDesignation())
                .build();
    }
}
