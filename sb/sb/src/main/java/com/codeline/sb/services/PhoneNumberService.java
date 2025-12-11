package com.codeline.sb.services;

import com.codeline.sb.DTORequest.PhoneNumberCreateRequest;
import com.codeline.sb.DTOResponse.PhoneNumberCreateResponse;
import com.codeline.sb.Entities.PhoneNumber;
import com.codeline.sb.Entities.Student;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import com.codeline.sb.repositories.PhoneNumberRepository;
import com.codeline.sb.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PhoneNumberService {
    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    StudentRepository studentRepository;

    public PhoneNumberCreateResponse addPhoneNumberToStudent(Integer studentId, PhoneNumberCreateRequest request) throws Exception {
        Student student = studentRepository.getStudentById(studentId);
        if (Utils.isNull(student)) {
            throw new Exception(Constants.STUDENT_ID_IS_NOT_VALID);
        } else {
            PhoneNumber phoneNumber = PhoneNumberCreateRequest.convertDTOToPhoneNumber(request);
            phoneNumber.setCreatedDate(new Date());
            phoneNumber.setIsActive(Boolean.TRUE);
            phoneNumber.setStudent(student);
            return PhoneNumberCreateResponse.convertPhoneNumberToDTO(phoneNumberRepository.save(phoneNumber));
        }
    }

    public PhoneNumberCreateResponse updatePhoneNumber(Integer id, PhoneNumberCreateRequest phoneNumber) throws Exception {
        PhoneNumber existing = phoneNumberRepository.getPhoneNumberById(id);
        if (Utils.isNull(existing)) {
            throw new Exception(Constants.PHONE_NUMBER_NOT_FOUND);
        } else {
            PhoneNumber updatedPhoneNumber = PhoneNumberCreateRequest.convertDTOToPhoneNumber(phoneNumber);
            updatedPhoneNumber.setCreatedDate(existing.getCreatedDate());
            updatedPhoneNumber.setUpdatedDate(new Date());
            updatedPhoneNumber.setIsActive(existing.getIsActive());
            updatedPhoneNumber.setId(existing.getId());
            updatedPhoneNumber.setStudent(existing.getStudent());
            return PhoneNumberCreateResponse.convertPhoneNumberToDTO(phoneNumberRepository.save(updatedPhoneNumber));
        }
    }

    public void deletePhoneNumber(Integer id) throws Exception {
        PhoneNumber existing = phoneNumberRepository.getPhoneNumberById(id);
        if (Utils.isNull(existing)) {
            throw new Exception(Constants.PHONE_NUMBER_NOT_FOUND);
        } else {
            existing.setUpdatedDate(new Date());
            existing.setIsActive(Boolean.FALSE);
            phoneNumberRepository.save(existing);
        }
    }
}
