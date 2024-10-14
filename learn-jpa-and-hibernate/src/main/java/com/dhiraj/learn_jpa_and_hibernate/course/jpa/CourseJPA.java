package com.dhiraj.learn_jpa_and_hibernate.course.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// we will be mapping Course bean directly to the table
// this class is called entiry
@Entity (name="Course")			// maps to table name Course
public class CourseJPA {
	
	@Id		// represent primar key
	private long id;
	
	@Column(name="name")	// optional, if this field name matched column name then no need to use this annotation
	private String name;
	
	@Column(name="author")
	private String author;
	
	public CourseJPA() {
		super();
	}

	public CourseJPA(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}
	
	

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
