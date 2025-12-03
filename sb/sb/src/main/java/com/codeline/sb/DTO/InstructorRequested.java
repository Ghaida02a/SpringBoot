package com.codeline.sb.DTO;

import com.codeline.sb.Entities.Instructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstructorRequested {
    @NotBlank(message = "Name must not be empty")
    String name;

    @NotBlank(message = "Email must not be empty")
    String email;

    @NotBlank
    @Size(min = 8, message = "Phone number must be at least 8 digits")
    String phoneNumber;

    @NotBlank(message = "Designation must not be empty")
    String designation;

    //    private Department department;
//    private Course course;
    private Integer departmentId;
    private Integer courseId;

    //convert DTO → Entity
    public static Instructor convertDTOToEntity(InstructorRequested dto) {
        if (dto == null) {
            return null;
        }
        return Instructor.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .designation(dto.getDesignation())
                .build();
    }

    // convert Entity → DTO
    public static InstructorRequested convertEntityToDTO(Instructor entity) {
        if (entity == null) {
            return null;
        }
        return InstructorRequested.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .designation(entity.getDesignation())
                .build();
    }
}
