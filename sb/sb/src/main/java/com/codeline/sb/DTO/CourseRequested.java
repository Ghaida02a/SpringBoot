package com.codeline.sb.DTO;

import com.codeline.sb.Entities.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequested {
    @NotBlank(message = "Course name cannot be empty")
    String name;

    @Positive(message = "Course hours must be positive")
    Double hours;

    //convert DTO → Entity
    public static Course convertDTOToEntity(CourseRequested dto) {
        if (dto == null) {
            return null;
        }
        return Course.builder()
                .name(dto.getName())
                .hours(dto.getHours())
                .build();
    }

    // convert Entity → DTO
//    public static CourseRequested convertEntityToDTO(Course entity) {
//        if (entity == null) {
//            return null;
//        }
//        return CourseRequested.builder()
//                .name(entity.getName())
//                .hours(entity.getHours())
//                .build();
//        }
    public static CourseRequested convertEntityToDTO(Course entity) {
        if (entity == null) return null;
        return CourseRequested.builder()
                .name(entity.getName())
                .hours(entity.getHours())
                .build();
    }
}
