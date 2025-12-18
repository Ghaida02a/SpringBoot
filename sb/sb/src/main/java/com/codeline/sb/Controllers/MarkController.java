package com.codeline.sb.Controllers;

import com.codeline.sb.DTORequest.MarkRequestDTO;
import com.codeline.sb.DTOResponse.MarkResponseDTO;
import com.codeline.sb.Entities.Mark;
import com.codeline.sb.Helper.Constants;
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

    @PutMapping("/{id}")
    public MarkResponseDTO updateMark(@PathVariable int id, @RequestBody MarkRequestDTO markRequestDTO) throws Exception {
        MarkRequestDTO.validateMarkRequestDTO(markRequestDTO);
        MarkResponseDTO updatedMark = markService.updateMark(id, markRequestDTO);
        return updatedMark;
    }

    @DeleteMapping("/{id}")
    public String deleteMark(@PathVariable int id) throws Exception {
        markService.deleteMark(id);
        return Constants.Success;
    }
}
