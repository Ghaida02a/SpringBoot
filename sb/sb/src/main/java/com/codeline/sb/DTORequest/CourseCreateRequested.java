package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Entities.Mark;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseCreateRequested {
    @NotBlank(message = "Course name cannot be empty")
    private String name;

    @Positive(message = "Course hours must be positive")
    private Double hours;

    private Integer instructorId;
    private Integer departmentId;
    private List<String> marks;

    //Validation
    public static void validateCourseCreateRequested(CourseCreateRequested dto) {
        if (Utils.isNull(dto.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course name cannot be empty");
        }
        if (Utils.isNull(dto.getHours()) || dto.getHours() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course hours must be greater than 0");
        }
        if (Utils.isNull(dto.getInstructorId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Instructor ID is not valid");
        }
        if (Utils.isNull(dto.getMarks())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marks are not valid");
        }
    }


    // Convert DTO → Entity
    public static Course convertDTOToEntity(CourseCreateRequested dto) {
        if (dto == null) return null;

        Course course = Course.builder()
                .name(dto.getName())
                .hours(dto.getHours())
                .build();
        return course;
    }

    // Convert Entity → DTO
    public static CourseCreateRequested convertEntityToDTO(Course entity) {
        if (entity == null) return null;
        return CourseCreateRequested.builder()
                .name(entity.getName())
                .hours(entity.getHours())
                .build();
    }
}
