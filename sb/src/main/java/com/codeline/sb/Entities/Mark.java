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
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double score;
    private String studentName;
    private Date createdDate;
    Date updatedDate;
    Boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    Course course;
}
