package com.codeline.sb.services;

import com.codeline.sb.DTORequest.AddressCreateRequest;
import com.codeline.sb.DTORequest.MarkRequestDTO;
import com.codeline.sb.DTOResponse.AddressCreateResponse;
import com.codeline.sb.DTOResponse.MarkResponseDTO;
import com.codeline.sb.Entities.Address;
import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Mark;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import com.codeline.sb.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public AddressCreateResponse updateAddressByStudentId(Integer studentId, AddressCreateRequest dto) throws Exception {
        Address existingAddress = addressRepository.getAddressByStudentId(studentId);
        if (Utils.isNull(existingAddress)) {
            throw new Exception(Constants.ADDRESS_NOT_FOUND);
        }

        Address updatedAddress = AddressCreateRequest.convertDTOToAddress(dto);
        updatedAddress.setId(existingAddress.getId());
        updatedAddress.setStudent(existingAddress.getStudent());
        updatedAddress.setCreatedDate(existingAddress.getCreatedDate());
        updatedAddress.setUpdatedDate(new Date());
        updatedAddress.setIsActive(existingAddress.getIsActive());

        return AddressCreateResponse.convertAddressToDTO(addressRepository.save(updatedAddress));
    }
}
