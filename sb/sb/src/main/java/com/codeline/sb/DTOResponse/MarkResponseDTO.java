package com.codeline.sb.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarkResponseDTO {
    private Integer id;
    private String studentName;
    private Double score;
    private String grade;
}
