package com.codeline.sb.DTOResponse;

import com.codeline.sb.Entities.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneNumberCreateResponse {
    private String phoneNumber;
    private String countryCode;
    private Boolean isLandLine;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

    //Convert dto -> entity
    public static PhoneNumber convertDTOToPhoneNumber(PhoneNumberCreateResponse dto){
        return PhoneNumber.builder()
                .phoneNumber(dto.getPhoneNumber())
                .countryCode(dto.getCountryCode())
                .isLandLine(dto.getIsLandLine())
                .isActive(dto.getIsActive())
                .createdDate(dto.getCreatedDate())
                .updatedDate(dto.getUpdatedDate())
                .build();
    }

    //Convert entity -> dto
    public static PhoneNumberCreateResponse convertPhoneNumberToDTO(PhoneNumber entity){
        return PhoneNumberCreateResponse.builder()
                .phoneNumber(entity.getPhoneNumber())
                .countryCode(entity.getCountryCode())
                .isLandLine(entity.getIsLandLine())
                .isActive(entity.getIsActive())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .build();
    }
}
