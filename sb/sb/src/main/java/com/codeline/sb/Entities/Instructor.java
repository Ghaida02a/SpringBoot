package com.codeline.sb.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String email;
    String phoneNumber;
    String designation;
    Date createdDate;
    Date UpdatedDate;
    Boolean isActive;


    @OneToOne
            @JoinColumn(name = "course")
    Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    Department department;
}
