package com.codeline.sb.DTOToCreate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Integer id;
    private String houseNumber;
    private String street;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
    private Integer studentId;
}
