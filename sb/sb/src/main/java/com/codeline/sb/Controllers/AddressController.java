package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.AddressCreateRequest;
import com.codeline.sb.DTOResponse.AddressCreateResponse;
import com.codeline.sb.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;

//    @PostMapping
//    public ResponseEntity<AddressCreateResponse> createAddress(@RequestBody AddressCreateRequest address) throws Exception {
//      AddressCreateRequest.validateAddressCreateRequest(address);
//      AddressCreateResponse createdAddress = addressService.saveAddress(address);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
//    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<AddressCreateResponse> updateAddress(@PathVariable Integer id, @RequestBody AddressCreateRequest address){
        try {
            AddressCreateRequest.validateAddressCreateRequest(address);
            return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(id, address));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
