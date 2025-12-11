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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

//    public AddressCreateResponse saveAddress(AddressCreateRequest request) {
//        Address address = AddressCreateRequest.convertDTOToAddress(request);
//        address.setCreatedDate(new Date());
//        address.setIsActive(Boolean.TRUE);
//
//        return AddressCreateResponse.convertAddressToDTO(addressRepository.save(address));
//    }


    public AddressCreateResponse updateAddress(Integer id, AddressCreateRequest address) throws Exception {
        Address existingAddress = addressRepository.getAddressById(id);
        if (Utils.isNull(existingAddress)) {
            throw new Exception(Constants.ADDRESS_NOT_FOUND);
        }
        Address updatedAddress = AddressCreateRequest.convertDTOToAddress(address);
        updatedAddress.setCreatedDate(existingAddress.getCreatedDate());
        updatedAddress.setUpdatedDate(new Date());
        updatedAddress.setIsActive(existingAddress.getIsActive());
        updatedAddress.setId(existingAddress.getId());
         return AddressCreateResponse.convertAddressToDTO(addressRepository.save(updatedAddress));

   }
}
