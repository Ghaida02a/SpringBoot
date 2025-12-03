package com.codeline.sb.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "course") // prevents recursion
public class Instructor {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String email;
    String phoneNumber;
    String designation;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;


    @OneToOne
            @JoinColumn(name = "course")
    Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    Department department;
}
