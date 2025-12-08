package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.InstructorCreateRequested;
import com.codeline.sb.DTOResponse.InstructorResponseDTO;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class InstructorController {

    @Autowired
    InstructorService instructorService;

//    @PostMapping("/createInstructor")
//    public String createIns(@RequestBody InstructorRequested requestObj) throws Exception{
//        Instructor ins = instructorService.saveInstructor(requestObj);
//        return Constants.Success + "Instructor created with ID: " + ins.getId();
//    }
    @PostMapping("/createInstructor")
    public ResponseEntity<InstructorResponseDTO> createInstructor(@RequestBody InstructorCreateRequested requestObj){
        try {
            InstructorCreateRequested.validateInstructorRequested(requestObj);
            InstructorResponseDTO createdInstructor = instructorService.saveInstructor(requestObj);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdInstructor);
        }
        catch (Exception err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    //display all Instructors
    @GetMapping("getAllInstructors")
    public List<Instructor> getAllInstructors(){
        List<Instructor> allInstructors = instructorService.getAllInstructors();
        return allInstructors;
    }

    //get Instructor by id
    @GetMapping("getInstructorById/{id}")
    public Instructor getInstructorById(@PathVariable int id) {
        return instructorService.getInstructorById(id);
    }

    //update Instructor
    @PutMapping("updateInstructor")
    public String updateInstructor(@RequestBody Instructor updateObjFromUser) throws Exception {
        return instructorService.updateInstructor(updateObjFromUser);
    }

    //delete Instructor by id
    @DeleteMapping("deleteInstructor/{id}")
    public String deleteInstructor(@PathVariable int id) throws Exception {
        instructorService.deleteInstructor(id);
        return Constants.Success;
    }
}
