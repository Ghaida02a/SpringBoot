package com.codeline.sb.services;

import com.codeline.sb.DTORequest.PhoneNumberCreateRequest;
import com.codeline.sb.DTORequest.StudentCreateRequest;
import com.codeline.sb.DTOResponse.StudentCreateResponse;
import com.codeline.sb.Entities.Address;
import com.codeline.sb.Entities.PhoneNumber;
import com.codeline.sb.Entities.Student;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import com.codeline.sb.repositories.AddressRepository;
import com.codeline.sb.repositories.PhoneNumberRepository;
import com.codeline.sb.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    AddressRepository addressRepository;

    // Get all active students
    public List<Student> getAllStudents() {
        return studentRepository.findAllActiveStudents();
    }

    public StudentCreateResponse saveStudent(StudentCreateRequest request) throws Exception {
        Student student = StudentCreateRequest.convertDTOToStudent(request);
        student.setIsActive(Boolean.TRUE);
        student.setCreatedDate(new Date());

        studentRepository.save(student);

        for (PhoneNumberCreateRequest phoneDto : request.getPhoneNumbers()) {
            PhoneNumber phone = new PhoneNumber();
            phone.setPhoneNumber(phoneDto.getPhoneNumber());
            phone.setCountryCode(phoneDto.getCountryCode());
            phone.setIsLandLine(phoneDto.getIsLandLine());
            phone.setIsActive(Boolean.TRUE);
            phone.setCreatedDate(new Date());
            phone.setStudent(student); // enforce composition
            phoneNumberRepository.save(phone);
        }

        if (request.getAddress() != null) {
            Address address = new Address();
            address.setHouseNumber(request.getAddress().getHouseNumber());
            address.setStreet(request.getAddress().getStreet());
            address.setCity(request.getAddress().getCity());
            address.setStateOrProvince(request.getAddress().getStateOrProvince());
            address.setCountry(request.getAddress().getCountry());
            address.setPostalCode(request.getAddress().getPostalCode());
            address.setIsActive(Boolean.TRUE);
            address.setCreatedDate(new Date());
            address.setStudent(student); // enforce composition
            addressRepository.save(address);
        }

        return StudentCreateResponse.convertStudentToDTO(student);
    }

    //Get Student by ID
    public Student getStudentById(int id) throws Exception {
        Student student = studentRepository.getStudentById(id);
        if (Utils.isNull(student)) {
            throw new Exception(Constants.STUDENT_ID_IS_NOT_VALID);
        }
        return student;
    }


    // Update Student safely
    public Student updateStudent(Student updateObj) throws Exception {
        Student existingOpt = studentRepository.getStudentById(updateObj.getId());

        if (Utils.isNotNull(existingOpt)) {
            existingOpt.setFirstName(updateObj.getFirstName());
            existingOpt.setLastName(updateObj.getLastName());
            existingOpt.setEmail(updateObj.getEmail());
            existingOpt.setGender(updateObj.getGender());
            existingOpt.setIsActive(Boolean.TRUE);
            existingOpt.setUpdatedDate(new Date());
            studentRepository.save(existingOpt);
            return existingOpt;
        } else {
            throw new Exception(Constants.Not_Found);
        }
    }

    //Soft delete student
    public void deleteStudent(Integer id) throws Exception {
        Student existingOpt = studentRepository.getStudentById(id);

        if (Utils.isNotNull(existingOpt)) {
            existingOpt.setIsActive(Boolean.FALSE);
            existingOpt.setUpdatedDate(new Date());
            studentRepository.save(existingOpt);
        } else {
            throw new Exception(Constants.Not_Found);
        }
    }
}
