package com.dhiraj.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dhiraj.learn_jpa_and_hibernate.course.jdbc.CourseJDBC;
import com.dhiraj.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.dhiraj.learn_jpa_and_hibernate.course.jpa.CourseJPA;
import com.dhiraj.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.dhiraj.learn_jpa_and_hibernate.course.springDataJpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	

//	@Autowired
//	private CourseJdbcRepository repository;
//	
//	// when you have some logic to run at the start of application
//	@Override
//	public void run(String... args) throws Exception {
////		repository.insert();
//		repository.insert(new CourseJDBC(1, "Devops", "Dhiraj"));
//		repository.insert(new CourseJDBC(2, "AWS", "in28mintues"));
//		repository.insert(new CourseJDBC(3, "Clouds", "ss"));
//		
//		repository.deleteById(1);
//		
//		System.out.println(repository.findById(2));
//		System.out.println(repository.findById(3));
//		
//	}
	
	
	

//	@Autowired
//	private CourseJpaRepository repository;
//	
//	// when you have some logic to run at the start of application
//	@Override
//	public void run(String... args) throws Exception {
////		repository.insert();
//		repository.insert(new CourseJPA(1, "JAVA", "Dhiraj"));
//		repository.insert(new CourseJPA(2, "Python", "in28mintues"));
//		repository.insert(new CourseJPA(3, "C++", "ss"));
//		
//		repository.deleteById(1);
//		
//		System.out.println(repository.findById(2));
//		System.out.println(repository.findById(3));
//		
//	}
//	
	
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new CourseJPA(1, "English", "Aman"));
		repository.save(new CourseJPA(2, "Marathi", "Malika"));
		repository.save(new CourseJPA(3, "Hindi", "John"));
		
		repository.deleteById(2l);
		
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Aman"));
		System.out.println(repository.findByName("Marathi"));	
		System.out.println(repository.findByName("English"));	
		
		
	}
	
	
	

}








