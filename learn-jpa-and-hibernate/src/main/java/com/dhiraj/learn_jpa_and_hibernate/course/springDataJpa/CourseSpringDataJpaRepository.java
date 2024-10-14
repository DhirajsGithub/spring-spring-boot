package com.dhiraj.learn_jpa_and_hibernate.course.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.learn_jpa_and_hibernate.course.jpa.CourseJPA;

public interface CourseSpringDataJpaRepository extends JpaRepository<CourseJPA, Long> {
	// we can also define our custom method
	
	// findByAttribure
	List<CourseJPA> findByAuthor(String aurhor);
	List<CourseJPA> findByName(String name);
}
