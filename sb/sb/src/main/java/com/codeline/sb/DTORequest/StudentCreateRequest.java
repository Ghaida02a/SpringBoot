package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Student;
import com.codeline.sb.Exceptions.CustomException;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;

    private List<PhoneNumberCreateRequest> phoneNumbers;
    private AddressCreateRequest address;


    //Validation
    public static void validateStudentCreateRequested(StudentCreateRequest dto) throws CustomException {
        if (Utils.isNull(dto.getFirstName())) {
            throw new CustomException(Constants.STUDENT_FIRST_NAME_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getLastName())) {
            throw new CustomException(Constants.STUDENT_Last_NAME_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getEmail())) {
            throw new CustomException(Constants.STUDENT_EMAIL_NAME_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getDateOfBirth())) {
            throw new CustomException(Constants.STUDENT_DATE_OF_BIRTH_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getGender())) {
            throw new CustomException(Constants.STUDENT_GENDER_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getPhoneNumbers()) || dto.getPhoneNumbers().isEmpty()) {
            throw new CustomException(Constants.STUDENT_PHONE_NUMBER_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        //Address can be null, so no validation
    }

    //Convert dto -> entity
    public static Student convertDTOToStudent(StudentCreateRequest studentDTO) {
        return Student.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail())
                .dateOfBirth(studentDTO.getDateOfBirth())
                .gender(studentDTO.getGender())
                .build();
    }

    //Convert entity -> dto request
    public static StudentCreateRequest convertStudentToDTO(Student student) {
        return StudentCreateRequest.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .dateOfBirth(student.getDateOfBirth())
                .gender(student.getGender())
                .build();
    }
}