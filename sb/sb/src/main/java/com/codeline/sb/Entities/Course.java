package com.codeline.sb.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@ToString(exclude = "instructor") // if Course has a back-reference
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Double hours;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Instructor instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Mark> marks = new ArrayList<>();
}
