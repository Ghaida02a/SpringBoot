package com.codeline.sb.services;

import com.codeline.sb.DTORequest.MarkRequestDTO;
import com.codeline.sb.DTOResponse.MarkResponseDTO;
import com.codeline.sb.Entities.Mark;
import com.codeline.sb.Helper.Constants;
import com.codeline.sb.Helper.Utils;
import com.codeline.sb.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    // Get all Marks
    public List<Mark> getAllMarks() {
        List<Mark> allMarks = markRepository.findAll();
        return allMarks;

    }

    //Save new Mark
    public MarkResponseDTO saveMark(MarkRequestDTO markRequestDTO) {
        Mark mark = MarkRequestDTO.convertDTOToEntity(markRequestDTO);
        mark.setCreatedDate(new Date());
        mark.setIsActive(Boolean.TRUE);
        return MarkResponseDTO.convertEntityToDTO(markRepository.save(mark));
    }

    //Get mark by ID
    public MarkResponseDTO getMarkById(Integer id) throws Exception {
        Mark mark = markRepository.findById(id).orElseThrow(() -> new Exception(Constants.MARK_NOT_FOUND));
        return MarkResponseDTO.convertEntityToDTO(mark);
    }
}
