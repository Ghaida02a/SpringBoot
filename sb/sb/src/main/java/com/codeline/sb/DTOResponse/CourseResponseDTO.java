package com.codeline.sb.DTOResponse;

import com.codeline.sb.Entities.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponseDTO {
    //private Integer id;
    private String name;
    private Double hours;
    private Date CreatedDate;
    private Date UpdatedDate;
    private Boolean isActive;

    // Instructor summary (id + name only)
    private InstructorSummaryDTO instructor;

    // List of marks with IDs
    private List<MarkResponseDTO> marks;

    // Convert Entity → ResponseDTO
    public static CourseResponseDTO entityToDTOResponse(Course entity) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setName(entity.getName());
        dto.setHours(entity.getHours());
        return CourseResponseDTO.builder()
                .name(entity.getName())
                .hours(entity.getHours())
                .CreatedDate(entity.getCreatedDate())
                .UpdatedDate(entity.getUpdatedDate())
                .isActive(entity.getIsActive())
                .instructor(entity.getInstructor() != null
                        ? InstructorSummaryDTO.builder()
                        .id(entity.getInstructor().getId())
                        .name(entity.getInstructor().getName())
                        .build()
                        : null)
                .marks(entity.getMarks() != null
                        ? entity.getMarks().stream()
                        .map(m -> MarkResponseDTO.builder()
                                .studentName(m.getStudentName())
                                .score(m.getScore())
                                .build())
                        .toList()
                        : null)
                .build();
    }

    //DTO Response -> Entity
    public static Course convertEntityToDTO(CourseResponseDTO dto) {
        if (dto == null) {
            return null;
        }
        return Course.builder()
                .name(dto.getName())
                .hours(dto.getHours())
                .createdDate(dto.getCreatedDate())
                .updatedDate(dto.getUpdatedDate())
                .isActive(dto.getIsActive())
                .build();
    }
}
