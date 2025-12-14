package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.MarkRequestDTO;
import com.codeline.sb.DTOResponse.MarkResponseDTO;
import com.codeline.sb.Entities.Mark;
import com.codeline.sb.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marks")
public class MarkController {

    @Autowired
    MarkService markService;

    @PostMapping
    public MarkResponseDTO createMarks(@RequestBody MarkRequestDTO requestDTO) {
        MarkRequestDTO.validateMarkRequestDTO(requestDTO);
        MarkResponseDTO createdMark = markService.saveMark(requestDTO);
        return createdMark;
    }

    @GetMapping
    public List<MarkResponseDTO> getAllMarks() {
        List<Mark> allMarks = markService.getAllMarks();
        return allMarks.stream()
                .map(MarkResponseDTO::convertEntityToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public MarkResponseDTO getMarkById(@PathVariable int id) throws Exception{
        return markService.getMarkById(id);
    }
}
