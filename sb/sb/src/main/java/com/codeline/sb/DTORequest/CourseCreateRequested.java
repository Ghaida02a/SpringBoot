package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Entities.Mark;
import com.codeline.sb.Exceptions.CustomException;
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
    private InstructorCreateRequested instructor;
    private DepartmentCreateRequested department;
    private List<MarkRequestDTO> marks;

    //Validation
    public static void validateCourseCreateRequested(CourseCreateRequested dto) throws CustomException {
        if (Utils.isNull(dto.getName())) {
            throw  new CustomException(Constants.COURSE_CREATE_REQUEST_NAME_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getHours()) || dto.getHours() <= 0) {
            throw new CustomException(Constants.COURSE_CREATE_REQUEST_HOURS_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        // instructorId and marks are optional for createCourseWithRelations
    }


    // Convert DTO → Entity
    public static Course convertDTOToEntity(CourseCreateRequested dto) {
        Course course = Course.builder()
                .name(dto.getName())
                .hours(dto.getHours())
                .build();
        return course;
    }

    // Convert Entity → DTO
    public static CourseCreateRequested convertEntityToDTO(Course entity) {
        return CourseCreateRequested.builder()
                .name(entity.getName())
                .hours(entity.getHours())
                .build();
    }
}
