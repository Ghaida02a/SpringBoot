package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Address;
import com.codeline.sb.Entities.PhoneNumber;
import com.codeline.sb.Entities.Student;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    private List<String> phoneNumbers;
    private Integer addressId;


    //Validation
    public static void validateStudentCreateRequested(StudentCreateRequest dto) throws Exception {
        if (Utils.isNull(dto.getFirstName())) {
            throw new Exception(Constants.STUDENT_FIRST_NAME_NOT_VALID);
        }
        if (Utils.isNull(dto.getLastName())) {
            throw new Exception(Constants.STUDENT_Last_NAME_NOT_VALID);
        }
        if (Utils.isNull(dto.getEmail())) {
            throw new Exception(Constants.STUDENT_EMAIL_NAME_NOT_VALID);
        }
        if (Utils.isNull(dto.getDateOfBirth())) {
            throw new Exception(Constants.STUDENT_DATE_OF_BIRTH_NOT_VALID);
        }
        if (Utils.isNull(dto.getGender())) {
            throw new Exception(Constants.STUDENT_GENDER_NOT_VALID);
        }
        if (Utils.isNull(dto.getPhoneNumbers())) {
            throw new Exception(Constants.STUDENT_PHONE_NUMBER_NOT_VALID);
        }
        if (Utils.isNull(dto.getAddressId())) {
            throw new Exception(Constants.STUDENT_ADDRESS_NOT_VALID);
        }
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
