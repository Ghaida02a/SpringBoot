package com.codeline.sb.DTOToCreate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneNumberDTO {
    private Integer id;
    private String phoneNumber;
    private String countryCode;
    private Boolean isLandLine;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
    private Integer studentId;
}
