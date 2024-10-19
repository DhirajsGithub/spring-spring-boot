package com.dhiraj.rest.webservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource; 
	
	// creating a simple restful api which return string
//	@RequestMapping(path="/hello-world", method=RequestMethod.GET)
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	// creating a api which returns instance of a class, or an api which return a bean 
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world");
	}
	
	// creating a path variable
	// /users/{id}/todos/{id}   --> /users/3/todos/14
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorlPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world, %s ", name));
	} 
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
		
		//return "Hello World V2"; 
		
		//1:
		//2:
//		- Example: `en` - English (Good Morning)
//		- Example: `nl` - Dutch (Goedemorgen)
//		- Example: `fr` - French (Bonjour)
//		- Example: `de` - Deutsch (Guten Morgen)

	}
	
	
}

/*
 
1. How are our request handled ? 
first the request goes to DispatcherServelet --> Front controller pattern
coz it's a mapping serverlet it is mapped to / 
then DispatcherServelet will map it to right controller method
DispatcherServelet is being auto configure by DispatcherServeletAutoConfiguration

 2. How does HellowWorldBean object get converted to JSON
 @ResponseBody + JacksonHttpMessageConverters (auto configure)
 
 3. Who is configuring error mapping
 ErrorMvcAutoConfiugration class
 
 4. How are all the jars available (Spring, Spring MVC, Jackson, Tomcat)
 starter projects
 
 
 Request method for REST Api
 GET : Retrieve details for a specific resource
 POST : Create a new resource
 PUT : update an existing resource
 PATCH : update part of a resource
 DELETE : Delete a resource
 
 Response status for REST API
 200 --> success
 201 --> created
 204 --> No content
 401 --> unauthorized (when authorization fails)
 400 --> Bad request (such as validation error)
 404 --> Resource not found
 500 --> server error
 
 Content Negotiation
 Same resources - Same URI
 different representations:
 	Accept conetent type : json, xml, ...
 	different languages : english, dutch, ..
 	
	Accept : application/xml, application/json
	// can be done using 
	  <dependency> 
		<groupId>com.fasterxml.jackson.dataformat</groupId> 
		<artifactId>jackson-dataformat-xml</artifactId>
	  </dependecy>
	  
	Accept-language : en, nl, fr, ....
	create .properties files in resources
	note the name should be messages.properties and messages_fr or _nl or ...
*/












