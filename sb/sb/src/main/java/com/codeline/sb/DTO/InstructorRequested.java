package com.codeline.sb.DTO;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Department;
import com.codeline.sb.Entities.Instructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @Min(message = "Phone number must not be empty", value = 8)
    String phoneNumber;

    @NotBlank(message = "Designation must not be empty")
    String designation;

    private Department department;
    private Course course;

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
