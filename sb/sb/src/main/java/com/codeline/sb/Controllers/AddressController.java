package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.AddressCreateRequest;
import com.codeline.sb.DTOResponse.AddressCreateResponse;
import com.codeline.sb.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students/{studentId}/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    //update
    @PutMapping
    public ResponseEntity<AddressCreateResponse> updateAddressByStudentId(
            @PathVariable Integer studentId,
            @RequestBody AddressCreateRequest address) throws Exception {

        AddressCreateRequest.validateAddressCreateRequest(address);
        AddressCreateResponse updatedAddress = addressService.updateAddressByStudentId(studentId, address);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAddress);
    }


}
