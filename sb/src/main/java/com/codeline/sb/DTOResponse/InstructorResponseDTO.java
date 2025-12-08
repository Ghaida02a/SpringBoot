package com.codeline.sb.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructorResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
}
