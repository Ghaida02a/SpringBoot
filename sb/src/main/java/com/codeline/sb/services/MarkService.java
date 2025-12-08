package com.codeline.sb.services;

import com.codeline.sb.Entities.Mark;
import com.codeline.sb.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public Mark saveMark(Mark mark) {
        mark.setCreatedDate(new Date());
        mark.setIsActive(Boolean.TRUE);
        return markRepository.save(mark);
    }

    //Get mark by ID
//    public Course getMarkById(int id) throws Exception {
//        Optional<Mark> markOpt = markRepository.findById(id);
//        if (markOpt != null) {
//            return markOpt.get();
//        } else {
//            throw new Exception(Constants.Not_Found);
//        }
//    }

//    // Update mark safely
//    public String updateMark(Mark updateObj) throws Exception {
//        Optional<Mark> existingOpt = markRepository.findById(updateObj.getId());
//
//        if (existingOpt.isPresent()) {
//            Course existingMark = existingOpt.get();
//
//            if (Boolean.TRUE.equals(existingMark.getIsActive())) {
//                // Only update fields provided
//                existingMark.setName(updateObj.getStudentName());
//                existingMark.setHours(updateObj.getScore());
//                existingMark.setUpdatedDate(new Date());
//                existingMark.setIsActive(Boolean.TRUE);
//
//                markRepository.save(existingMark);
//                return Constants.Success;
//            } else {
//                throw new Exception(Constants.Bad_Request);
//            }
//        } else {
//            throw new Exception(Constants.Not_Found);
//        }
//    }

//    //Soft delete course
//    public void deleteCourse(Integer id) throws Exception {
//        Optional<Course> existingOpt = courseRepository.findById(id);
//
//        if (existingOpt.isPresent()) {
//            Course existingCourse = existingOpt.get();
//
//            if (Boolean.TRUE.equals(existingCourse.getIsActive())) {
//                existingCourse.setUpdatedDate(new Date());
//                existingCourse.setIsActive(Boolean.FALSE);
//                courseRepository.save(existingCourse);
//            } else {
//                throw new Exception(Constants.Bad_Request);
//            }
//        } else {
//            throw new Exception(Constants.Not_Found);
//        }
//    }
}
