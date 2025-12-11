package com.codeline.sb.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

    @OneToMany(mappedBy = "student")
    private List<PhoneNumber> phoneNumbers;

    @OneToOne(mappedBy = "student")
    private Address address;
}
