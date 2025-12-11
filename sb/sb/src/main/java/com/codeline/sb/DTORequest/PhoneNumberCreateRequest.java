package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.PhoneNumber;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneNumberCreateRequest {
    private String phoneNumber;
    private String countryCode;
    private Boolean isLandLine;

    private Integer studentId;

    public static void validatePhoneNumberCreateRequested(PhoneNumberCreateRequest dto) throws Exception {
        if (Utils.isNull(dto.getPhoneNumber())) {
            throw new Exception(Constants.PHONE_NUMBER_NOT_VALID);
        }
        if (Utils.isNull(dto.getCountryCode())) {
            throw new Exception(Constants.PHONE_NUMBER_COUNTRY_CODE_NOT_VALID);
        }
        if (Utils.isNull(dto.getIsLandLine())) {
            throw new Exception(Constants.PHONE_NUMBER_LAND_LINE_NOT_VALID);
        }
        if (Utils.isNull(dto.getStudentId())) {
            throw new Exception(Constants.PHONE_NUMBER_STUDENT_ID_NOT_VALID);
        }
    }

    //Convert dto -> entity
    public static PhoneNumber convertDTOToPhoneNumber(PhoneNumberCreateRequest dto) {
        return PhoneNumber.builder()
                .phoneNumber(dto.getPhoneNumber())
                .countryCode(dto.getCountryCode())
                .isLandLine(dto.getIsLandLine())
                .build();
    }

    //Convert entity -> dto
    public static PhoneNumberCreateRequest convertPhoneNumberToDTO(PhoneNumber phoneNumber) {
        return PhoneNumberCreateRequest.builder()
                .phoneNumber(phoneNumber.getPhoneNumber())
                .countryCode(phoneNumber.getCountryCode())
                .isLandLine(phoneNumber.getIsLandLine())
                .build();
    }
}
