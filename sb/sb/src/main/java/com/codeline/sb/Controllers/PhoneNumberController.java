package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.PhoneNumberCreateRequest;
import com.codeline.sb.DTOResponse.PhoneNumberCreateResponse;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
public class PhoneNumberController {
    @Autowired
    PhoneNumberService phoneNumberService;

    //POST /students/{id}/phoneNumbers/add
    @PostMapping("/{studentId}/add")
    public ResponseEntity<PhoneNumberCreateResponse> addPhoneNumberToStudent(@PathVariable Integer studentId, @RequestBody PhoneNumberCreateRequest phoneNumber) throws Exception {
        PhoneNumberCreateRequest.validatePhoneNumberCreateRequested(phoneNumber);
        PhoneNumberCreateResponse createdPhoneNumber = phoneNumberService.addPhoneNumberToStudent(studentId, phoneNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPhoneNumber);
    }
    //PUT /phoneNumbers/{id}/update
    @PutMapping("/{id}")
    public ResponseEntity<PhoneNumberCreateResponse> updatePhoneNumber(@PathVariable Integer id, @RequestBody PhoneNumberCreateRequest phoneNumber) throws Exception {
        try {
            PhoneNumberCreateRequest.validatePhoneNumberCreateRequested(phoneNumber);
            return ResponseEntity.status(HttpStatus.OK).body(phoneNumberService.updatePhoneNumber(id, phoneNumber));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    //DELETE /phoneNumbers/{id}/delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePhoneNumber(@PathVariable Integer id) throws Exception {
        phoneNumberService.deletePhoneNumber(id);
        return ResponseEntity.status(HttpStatus.OK).body(Constants.PHONE_NUMBER_DELETED_SUCCESS);
    }
}
