package com.codeline.sb.DTORequest;

import com.codeline.sb.Entities.Address;
import com.codeline.sb.Exceptions.CustomException;
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
public class AddressCreateRequest {
    private String houseNumber;
    private String street;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    private Integer studentId;

    public static void validateAddressCreateRequest(AddressCreateRequest dto) throws CustomException {
        if (Utils.isNull(dto.getHouseNumber())) {
            throw new CustomException(Constants.ADDRESS_HOUSE_NUMBER_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getStreet())) {
            throw new CustomException(Constants.ADDRESS_STREET_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getCity())) {
            throw new CustomException(Constants.ADDRESS_CITY_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getStateOrProvince())) {
            throw new CustomException(Constants.ADDRESS_STATE_OR_PROVINCE_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getCountry())) {
            throw new CustomException(Constants.ADDRESS_COUNTRY_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getPostalCode())) {
            throw new CustomException(Constants.ADDRESS_POSTAL_CODE_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
        if (Utils.isNull(dto.getStudentId())) {
            throw new CustomException(Constants.ADDRESS_STUDENT_ID_NOT_VALID, Constants.HTTP_STATUS_IS_NULL);
        }
    }

    //Convert dto ->  entity
    public static Address convertDTOToAddress(AddressCreateRequest dto) {
        return Address.builder()
                .houseNumber(dto.getHouseNumber())
                .street(dto.getStreet())
                .city(dto.getCity())
                .stateOrProvince(dto.getStateOrProvince())
                .country(dto.getCountry())
                .postalCode(dto.getPostalCode())
                .build();
    }

    //Convert entity -> dto
    public static AddressCreateRequest convertAddressToDTO(Address entity) {
        return AddressCreateRequest.builder()
                .houseNumber(entity.getHouseNumber())
                .street(entity.getStreet())
                .city(entity.getCity())
                .stateOrProvince(entity.getStateOrProvince())
                .country(entity.getCountry())
                .postalCode(entity.getPostalCode())
                .build();
    }
}
