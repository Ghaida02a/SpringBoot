package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Mark;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarkRequestDTO {

    @NotNull(message = "Score cannot be null")
    @Positive(message = "Score must be positive")
    private Double score;

    @NotBlank(message = "Student name cannot be empty")
    private String studentName;

    // Convert DTO → Entity
    public static Mark convertDTOToEntity(MarkRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return com.codeline.sb.Entities.Mark.builder()
                .studentName(dto.getStudentName())
                .score(dto.getScore())
                .build();
    }

    // Convert Entity → DTO
    public static MarkRequestDTO convertEntityToDTO(Mark entity) {
        if (entity == null) {
            return null;
        }
        return MarkRequestDTO.builder()
                .studentName(entity.getStudentName())
                .score(entity.getScore())
                .build();
    }
}
