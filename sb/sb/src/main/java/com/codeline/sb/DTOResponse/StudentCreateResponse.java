package com.codeline.sb.DTOResponse;

import com.codeline.sb.Entities.Student;
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
public class StudentCreateResponse {
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

    private List<PhoneNumberCreateResponse> phoneNumbers;

    private AddressCreateResponse address;

    //Convert dto response -> entity
    public static Student convertDTOToEntity(StudentCreateResponse dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setDateOfBirth(dto.getDateOfBirth());
        student.setGender(dto.getGender());
        student.setIsActive(dto.getIsActive());
        student.setCreatedDate(dto.getCreatedDate());
        student.setUpdatedDate(dto.getUpdatedDate());
        return student;
    }

    //Convert entity -> dto response
    public static StudentCreateResponse convertStudentToDTO(Student student){
        StudentCreateResponse response = new StudentCreateResponse();
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setDateOfBirth(student.getDateOfBirth());
        response.setGender(student.getGender());
        response.setIsActive(student.getIsActive());
        response.setCreatedDate(student.getCreatedDate());
        response.setUpdatedDate(student.getUpdatedDate());
        return response;
    }
}
