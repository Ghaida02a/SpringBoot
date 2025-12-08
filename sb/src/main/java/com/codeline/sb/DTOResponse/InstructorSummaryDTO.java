package com.codeline.sb.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructorSummaryDTO {
    private Integer id;
    private String name;
}
