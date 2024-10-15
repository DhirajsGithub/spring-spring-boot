package com.dhiraj.learn_jpa_and_hibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional		// to executre query using JPA
public class CourseJpaRepository {
	// helps to talk to DB using JPA
	@PersistenceContext  // more specific annotation instead of autowired // @Autowired
	private EntityManager entityManager;
	
	public void insert(CourseJPA course) {
		entityManager.merge(course);
	}
	
	public CourseJPA findById(long id) {
		return entityManager.find(CourseJPA.class, id);
	}
	
	public void deleteById(long id) {
		CourseJPA course = entityManager.find(CourseJPA.class, id);
		entityManager.remove(course);
	}
}