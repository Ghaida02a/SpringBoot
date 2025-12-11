package com.codeline.sb.DTOResponse;

import com.codeline.sb.Entities.Address;
import com.codeline.sb.Entities.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressCreateResponse {
    private String houseNumber;
    private String street;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

    private Student student;

    //Convert dto -> entity
    public static Address convertDTOToAddress(AddressCreateResponse dto) {
        return Address.builder()
                .houseNumber(dto.getHouseNumber())
                .street(dto.getStreet())
                .city(dto.getCity())
                .stateOrProvince(dto.getStateOrProvince())
                .country(dto.getCountry())
                .postalCode(dto.getPostalCode())
                .isActive(dto.getIsActive())
                .createdDate(dto.getCreatedDate())
                .updatedDate(dto.getUpdatedDate())
                .student(dto.getStudent())
                .build();
    }

    //Convert entity -> dto
    public static AddressCreateResponse convertAddressToDTO(Address entity) {
        return AddressCreateResponse.builder()
                .houseNumber(entity.getHouseNumber())
                .street(entity.getStreet())
                .city(entity.getCity())
                .stateOrProvince(entity.getStateOrProvince())
                .country(entity.getCountry())
                .postalCode(entity.getPostalCode())
                .isActive(entity.getIsActive())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .student(entity.getStudent())
                .build();
    }
}
