package com.student.repositaory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	
}

