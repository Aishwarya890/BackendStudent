package com.student.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String mobile;

//    @ElementCollection
//    private List<String> backgroundEducationDetails;

    

    // Background Education Details
 // 10th education details
    @Column(name = "tenth_passing_year")
    private String tenthPassingYear;
    
    @Column(name = "tenth_marks")
    private String tenthMarks;
    
    @Column(name = "tenth_board")
    private String tenthBoard;

    // 12th education details
    @Column(name = "twelfth_passing_year")
    private String twelfthPassingYear;
    
    @Column(name = "twelfth_marks")
    private String twelfthMarks;
    
    @Column(name = "twelfth_board")
    private String twelfthBoard;

    // Graduation education details
    @Column(name = "graduation_passing_year")
    private String graduationPassingYear;
    
    @Column(name = "graduation_marks")
    private String graduationMarks;
    
    @Column(name = "graduation_board")
    private String graduationBoard;

    // getters and setters

    @ManyToMany
    private List<Subject> subjects;

    // Getters and Setters
}
