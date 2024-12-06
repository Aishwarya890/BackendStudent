package com.student.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String mobile;
    private List<String> backgroundEducationDetails;
    private List<Long> subjectIds; 
}

