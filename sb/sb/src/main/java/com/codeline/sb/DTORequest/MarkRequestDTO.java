package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Mark;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import jakarta.persistence.*;
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
public class MarkRequestDTO {
    private Double score;
    private String studentName;

    private Integer courseId;

    //Validation
    public static void validateMarkRequestDTO(MarkRequestDTO dto) {
        if (Utils.isNull(dto.getScore()) || dto.getScore() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.MARK_SCORE_NOT_VALID);
        }
        if (Utils.isNull(dto.getStudentName()) || dto.getStudentName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.MARK_STUDENT_NAME_NOT_VALID);
        }
        if (Utils.isNull(dto.getCourseId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.MARK_COURSE_ID_NOT_VALID);
        }
    }

    // Convert DTO → Entity
    public static Mark convertDTOToEntity(MarkRequestDTO dto) {
        return com.codeline.sb.Entities.Mark.builder()
                .studentName(dto.getStudentName())
                .score(dto.getScore())
                .build();
    }

    // Convert Entity → DTO
    public static MarkRequestDTO convertEntityToDTO(Mark entity) {
        return MarkRequestDTO.builder()
                .studentName(entity.getStudentName())
                .score(entity.getScore())
                .build();
    }
}
