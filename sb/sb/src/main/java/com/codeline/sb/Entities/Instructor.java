package com.codeline.sb.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@ToString(exclude = "course") // prevents recursion
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String designation;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;


    @OneToOne
            @JoinColumn(name = "course")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;
}
