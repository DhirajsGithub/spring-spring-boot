package com.dhiraj.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController 	// commnd + shift + o  --> organing imports
public class CourseController {
	
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		// command 1 to create class Course
		return Arrays.asList(
				new Course(1, "Learn AWS", "in28minutes"), 
				new Course(2, "Learn DEVOPS", "in28minutes"),
				new Course(3, "Learn AZURE", "in28minutes"),
				new Course(4, "Learn SPRING", "in28minutes")
				
				);
	}

}
