package com.dhiraj.rest.webservices.restful_web_services.user;
import java.net.URI;
import java.util.List;

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
	public User retrieveUser(@PathVariable int id) {
		
		User user = service.findOne(id);
		if(user == null) {
			 throw new UserNotFoundException("id " + id);
		}
		return user;
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




