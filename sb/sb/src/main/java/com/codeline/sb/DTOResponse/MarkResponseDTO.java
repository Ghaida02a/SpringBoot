package com.codeline.sb.DTOResponse;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Mark;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarkResponseDTO {
    private Double score;
    private String studentName;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;
    private Integer courseId;

    //convert Mark -> MarkResponseDTO
    public static MarkResponseDTO convertEntityToDTO(Mark mark){
        return MarkResponseDTO.builder()
                .score(mark.getScore())
                .studentName(mark.getStudentName())
                .createdDate(mark.getCreatedDate())
                .updatedDate(mark.getUpdatedDate())
                .isActive(mark.getIsActive())
                .courseId(mark.getCourse().getId())
                .build();
    }

    //convert MarkResponseDTO -> Mark
    public static Mark convertDTOToEntity(MarkResponseDTO dto, Course course){
        return Mark.builder()
                .score(dto.getScore())
                .studentName(dto.getStudentName())
                .createdDate(dto.getCreatedDate())
                .updatedDate(dto.getUpdatedDate())
                .isActive(dto.getIsActive())
                .course(course)
                .build();
    }
}
