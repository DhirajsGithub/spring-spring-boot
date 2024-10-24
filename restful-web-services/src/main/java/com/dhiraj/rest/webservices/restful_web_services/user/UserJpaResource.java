package com.dhiraj.rest.webservices.restful_web_services.user;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.dhiraj.rest.webservices.restful_web_services.jpa.PostRepository;
import com.dhiraj.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserRepository repository;
	private PostRepository postRepository;
	
	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping(path="/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping(path="/jpa/users/{id}")
	// doing HATEOAS
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			 throw new UserNotFoundException("id " + id);
		}
		
		// we want /users as all_users of _links
		
		// EntityModel
		// WebMvcLinkBuilder
		 
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		// linkTo(methodOn(className.methodName)
		entityModel.add(link.withRel("all-users"));
		// field name of a link
		
		// we can create links associated with the api and add them in entity model 
		
		return entityModel;
	}
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
				
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
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void delteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@GetMapping(path="/jpa/users/{id}/post")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id : " + id);
		}
		
		// user.get() will return a user, coz we are using Optional
		return user.get().getPosts();
	}
	
	@PostMapping(path="/jpa/users/{id}/post")
	public ResponseEntity<Post> createPostForUser(@PathVariable int id,  @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id : " + id);
		}
		
		post.setUser(user.get());
		
		Post savedPost = postRepository.save(post);
				
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
	    return ResponseEntity.created(location).body(savedPost);

	}
	
	@GetMapping(path="/jpa/users/{userId}/post/{postId}")
	public EntityModel<Post> retrievePost(@PathVariable int userId, @PathVariable int postId) {
		
		Optional<User> user = repository.findById(userId);
		if(user.isEmpty()) {
			 throw new UserNotFoundException("id " + userId);
		}
		
		Optional<Post> post = postRepository.findById(postId);
		if(post.isEmpty()) {
			throw new UserNotFoundException("post id  " + postId);
		}
		
		EntityModel<Post> entityModel = EntityModel.of(post.get());
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrievePostsForUser(userId));
		entityModel.add(link.withRel("all-posts"));		
		return entityModel;
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
























