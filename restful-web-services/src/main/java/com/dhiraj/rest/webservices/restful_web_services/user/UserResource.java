package com.dhiraj.rest.webservices.restful_web_services.user;
import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	// doing HATEOAS
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		
		User user = service.findOne(id);
		if(user == null) {
			 throw new UserNotFoundException("id " + id);
		}
		
		// we want /users as all_users of _links
		
		// EntityModel
		// WebMvcLinkBuilder
		 
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		// linkTo(methodOn(className.methodName)
		entityModel.add(link.withRel("all-users"));
		// field name of a link
		
		// we can create links associated with the api and add them in entity model 
		
		return entityModel;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
				
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		// ServletUriComponentsBuilder.fromCurrentRequest() --> /users
		// .path("/{id}")  --> /users/id
		// to
		// return ResponseEntity.created(location).build();
		// Return both the location header and the saved user object in the response body
	    return ResponseEntity.created(location).body(savedUser);

	}
	
	@DeleteMapping(path="/users/{id}")
	public void delteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	
}


/*
HATEOAS
Hypermedia As The Ending Of Application State
websites allow you to : 
	see data and perform actions (using links)
 	
How about enhancing your REST API to tell consumers how to perform subsequence actions ? 
implementation options : 
	1. Custom format and implementation 
		 - difficult to maintain
 	2. User standard implementation
 		- HAL (JSON Hypertext Application Language) : Simple format that gives a consistent
 		and easy way to hyperlink between resources in your API
 		- spring hateoas : Generate HAL responses with hyperlinks to resources
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-hateoas</artifactId>
		</dependecy>
	
	
 */
























