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
@Table
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String phoneNumber;
    private String countryCode;
    private Boolean isLandLine;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;
}
