package com.codeline.sb.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
}
