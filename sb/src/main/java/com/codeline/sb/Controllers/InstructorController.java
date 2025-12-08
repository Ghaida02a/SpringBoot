package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.InstructorRequested;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @PostMapping("/createInstructor")
    public String createIns(@RequestBody InstructorRequested requestObj) throws Exception{
        Instructor ins = instructorService.saveInstructor(requestObj);
        return Constants.Success + "Instructor created with ID: " + ins.getId();
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
