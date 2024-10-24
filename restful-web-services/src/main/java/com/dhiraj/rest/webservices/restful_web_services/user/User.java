package com.dhiraj.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Min two characters for name field")
//	@JsonProperty("user_name")   // chaning field name from name to user_name
	private String name;
	
	@Past(message="birth of date must be in past")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore		// ignores post while fetching user detail
	private List<Post> posts;
	
	protected User() {
		
	}
	
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

}


/*
 Customizing REST API responses - Filtering and more...
 
 Serialization : Convert Object to stream (example JSON) 
 	in java : Jackson is most popular JSON serialization
 	
Customizing REST API responses return by jackson frameword : 
	1. customize field name in response --> @JSONProperty
	2. return only selected field : 
		Filtering : 
			1. static filtering : Same filtering for a bean across different REST API
				@JsonIgnoreProperties, @JsonIgnore
			2. Dynamic filtering : Customize filtering for a bean for specific REST API
				@JsonFilter with filter provider
 
  
 */














