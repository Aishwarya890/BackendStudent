package com.student.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.entity.StudentDTO;
import com.student.entity.Subject;
import com.student.repositaory.StudentRepository;
import com.student.repositaory.SubjectRepository;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
    private final StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public StudentController(StudentService
    		studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

//    @PostMapping
//    public Student createStudent(@RequestBody Student student) {
//        // Validate and retrieve subjects only if IDs are present
//        if (student.getSubjects() != null && !student.getSubjects().isEmpty()) {
//            List<Long> subjectIds = student.getSubjects().stream()
//                    .map(Subject::getId)
//                    .filter(id -> id != null) // Filter out null IDs
//                    .collect(Collectors.toList());
//                    
//            if (!subjectIds.isEmpty()) {
//                List<Subject> subjects = subjectRepository.findAllById(subjectIds);
//                student.setSubjects(subjects);
//            }
//        }
//        return studentRepository.save(student);
//    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        // Check if the student exists
        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent == null) {
            return ResponseEntity.notFound().build(); // If student not found, return 404
        }

        // Update the existing student details
        existingStudent.setName(studentDetails.getName());
        existingStudent.setAddress(studentDetails.getAddress());
        existingStudent.setTenthBoard(studentDetails.getTenthBoard());
        existingStudent.setTwelfthBoard(studentDetails.getTwelfthBoard());
        existingStudent.setGraduationBoard(studentDetails.getGraduationBoard());
        existingStudent.setMobile(studentDetails.getMobile());
        // Update other fields as necessary
        existingStudent.setDateOfBirth(studentDetails.getDateOfBirth());;
        existingStudent.setSubjects(studentDetails.getSubjects()); // Update subjects, if necessary

        // Save the updated student to the database
        Student updatedStudent = studentService.saveStudent(existingStudent);

        return ResponseEntity.ok(updatedStudent); // Return the updated student
    }
}
