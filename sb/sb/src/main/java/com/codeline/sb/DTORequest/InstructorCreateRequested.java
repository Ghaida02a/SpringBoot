package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Instructor;
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
    public static void validateInstructorRequested(InstructorCreateRequested dto) {
        if (Utils.isNull(dto.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INSTRUCTOR_NAME);
        }
       if(Utils.isNull(dto.getEmail())) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INSTRUCTOR_EMAIL);
       }
       if(Utils.isNull(dto.getPhoneNumber())) {
              throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INSTRUCTOR_PHONE_NUMBER);
       }
       if(Utils.isNull(dto.getDesignation())) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.INSTRUCTOR_DESIGNATION);
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
