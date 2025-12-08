package com.codeline.sb.DTOResponse;

import com.codeline.sb.Entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructorResponseDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String designation;


    // Convert Instructor → ResponseDTO
    public static InstructorResponseDTO convertInstructorToDTOResponse(Instructor entity) {
        if (entity == null) return null;
        return InstructorResponseDTO.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .designation(entity.getDesignation())
                .build();
    }

    //convert ResponseDTO to Entity
    public static Instructor convertDTOResponseToEntity(InstructorResponseDTO dto) {
        Instructor entity = new Instructor();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setDesignation(dto.getDesignation());
        return entity;
    }
}