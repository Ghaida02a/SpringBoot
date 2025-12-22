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
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @PostMapping
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
    @GetMapping
    public List<InstructorResponseDTO> getAllInstructors(){
        List<Instructor> allInstructors = instructorService.getAllInstructors();
        return allInstructors.stream()
                .map(InstructorResponseDTO::convertInstructorToDTOResponse)
                .toList();
    }

    //get Instructor by id
    @GetMapping("/{id}")
    public InstructorResponseDTO getInstructorById(@PathVariable int id) {
        Instructor instructor = instructorService.getInstructorById(id);
        return InstructorResponseDTO.convertInstructorToDTOResponse(instructor);
    }

    //update Instructor
    @PutMapping("/{id}")
    public String updateInstructor(@PathVariable int id,@RequestBody Instructor updateObjFromUser) throws Exception {
        return instructorService.updateInstructor(updateObjFromUser);
    }

    //delete Instructor by id
    @DeleteMapping("/{id}")
    public String deleteInstructor(@PathVariable int id) throws Exception {
        instructorService.deleteInstructor(id);
        return Constants.Success;
    }
}
