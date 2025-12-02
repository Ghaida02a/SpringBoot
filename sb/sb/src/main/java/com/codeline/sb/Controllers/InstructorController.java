package com.codeline.sb.Controllers;

import com.codeline.sb.Entities.Course;
import com.codeline.sb.Entities.Instructor;
import com.codeline.sb.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @PostMapping("/createIns")
    public String createIns(@RequestBody Instructor requestObj){
        Instructor ins = instructorService.saveInstructor(requestObj);
        return "Instructor created with ID: " + ins.getId();
    }
}
