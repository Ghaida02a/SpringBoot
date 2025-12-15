package com.codeline.sb.DTOToCreate;

import jakarta.persistence.Entity;
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
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

    private List<PhoneNumberDTO> phoneNumbers;
    private AddressDTO address;
}
