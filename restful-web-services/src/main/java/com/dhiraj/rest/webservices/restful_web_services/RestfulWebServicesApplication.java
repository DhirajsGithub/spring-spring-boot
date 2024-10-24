package com.dhiraj.rest.webservices.restful_web_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}


/*
	get production ready with spring boot actuator 
	- monitor and manages your application in production
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	- provides a number of endpoints 
		- beans : complete list of spring beans in your app
		- health : application health information
		- metrics : application metrics
		- mappings : details around request mappings
		- and more...
		
	Explore REST API using HAL explorer
	HAL (JSON hypertext application language)
		simple format that gives consistent and easy way to hyperlink between resources in your api
	HAL explorer
		an api explorer like swagger
	Spring boot HAL explorer
		auto configures HAL explorer for spring boot projects
	<dependency>
		<groupId>org.springframework.data</groupId>
		<artifactId>spring-data-rest-hal-explorer</artifactId>
	</dependency>
	then http://localhost:8080/
	
*/