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
    private String name;
    private Double hours;

    private Integer instructorId;
    private Integer departmentId;
    private List<String> marks;

    //Validation
    public static void validateCourseCreateRequested(CourseCreateRequested dto) {
        if (Utils.isNull(dto.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.COURSE_NAME);
        }
        if (Utils.isNull(dto.getHours()) || dto.getHours() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.COURSE_HOURS_NOT_VALID);
        }
        if (Utils.isNull(dto.getInstructorId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }
        if (Utils.isNull(dto.getMarks())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Constants.COURSE_CREATE_REQUEST_MARKS_NOT_VALID);
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
