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
    int id;

    String name;
    Double hours;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    Instructor instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Mark> marks = new ArrayList<>();
}
