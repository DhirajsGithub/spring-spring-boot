package com.dhiraj.learn_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}

/*
Getting Started with Spring Boot
WHY Spring Boot?
	- You can build web apps & REST API WITHOUT Spring Boot
	- What is the need for Spring Boot?
WHAT are the goals of Spring Boot?
HOW does Spring Boot work?
COMPARE Spring Boot vs Spring MVC vs Spring

World Before Spring Boot!
	Setting up Spring Projects before Spring Boot was NOT easy!
		1: Dependency Management (pom.xml)
		2: Define Web App Configuration (web.xml)
		3: Manage Spring Beans (context.xml)
		4: Implement Non Functional Requirements (NFRs) --> Logging, Error Handling, Monitoring
		AND repeat this for every new project!
	We needed to configure a lot of things before we have a production-ready application

What's the Most Important Goal of Spring Boot?
Help you build PRODUCTION-READY apps QUICKLY
Build QUICKLY
	- Spring Initializr
	- Spring Boot Starter Projects 
	- Spring Boot Auto Configuration 
	- Spring Boot DevTools

Be PRODUCTION-READY 
	- Logging
	- Different Configuration for Different Environments 
		- Profiles, ConfigurationProperties
	- Monitoring (Spring Boot Actuator)

Exploring Spring Boot Starter Projects
- I need a lot of frameworks to build application features:
	- Build a REST API: I need Spring, Spring MVC, Tomcat, JSON conversion...
	- Write Unit Tests: I need Spring Test, JUnit, Mockito, ...
How can I group them and make it easy to build applications?
	- Starters: Convenient dependency descriptors for diff. features
Spring Boot provides variety of starter projects:
	Web Application & REST API - Spring Boot Starter Web (spring-webmvc, spring-web, spring-boot-starter-tomcat, spring-boot-starter-json)
	Unit Tests - Spring Boot Starter Test
	Talk to database using JPA - Spring Boot Starter Data JPA
	Talk to database using JDBC - Spring Boot Starter JDBC
	Secure your web application or REST API - Spring Boot Starter Security

Exploring Spring Boot Auto Configuration
- I need lot of configuration to build Spring app:
	- Component Scan, DispatcherServlet, Data Sources, JSON Conversion, ...
- How can I simplify this?
	- Auto Configuration: Automated configuration for your app
	- Decided based on:
		- Which frameworks are in the Class Path?
		- What is the existing configuration (Annotations etc)?
Example: Spring Boot Starter Web
	- Dispatcher Servlet (DispatcherServletAutoConfiguration) 
	- Embedded Servlet Container - Tomcat is the default
	(EmbeddedWebServerFactoryCustomizerAutoConfiguration) 
	- Default Error Pages (ErrorMvcAutoConfiguration)
	- Bean<->JSON (JacksonHttpMessageConvertersConfiguration)	

Build Faster with Spring Boot DevTools
	- add in pom.xml
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		<optional>true</optional>
	</dependency>
	- Increase developer productivity
	- Why do you need to restart the server manually for every code change?
	- Remember: For pom.xml dependency changes, you will need to restart server manually

Managing App. Configuration using Profiles
	- Applications have different environments: Dev, QA, Stage, Prod, ...
	- Different environments need different configuration: 
		- Different Databases
		- Different Web Services
	- How can you provide different configuration for different environments?
		- Profiles: Environment specific configuration
	- How can you define externalized configuration for your application?
		- ConfigurationProperites: Define externalized configuration
e.g. we make application-dev.properties and application-prod.properties content is logging.level.org.springframework=info for prod and 
and int application.properties we define spring.profiles.active=prod so prod logs will get printed
logs are 
- trace		// will print all below logs (from debug to error)
- debug		// will print (info to error) and so on for below
- info
- warning
- error
- off


Simplify Deployment with Spring Boot Embedded Servers
How do you deploy your application (Old way)
	Step 1 : Install Java
	Step 2 : Install Web/Application Server
		Tomcat/WebSphere/WebLogic etc
	Step 3 : Deploy the application WAR (Web ARchive)
	
Embedded Server - Simpler alternative 
	Step 1 : Install Java
	Step 2 : Run JAR file
	$ mvn clean install or right click on package > run as > maven build > goals clean install
	copy [INFO] Building jar: /Users/dhiraj/Desktop/spring&spring_boot/learn-spring-boot/target/learn-spring-boot-0.0.1-SNAPSHOT.jar
	go in cd /Users/dhiraj/Desktop/spring&spring_boot/learn-spring-boot/target/
	java -jar learn-spring-boot-0.0.1-SNAPSHOT.jar

	Make JAR not WAR (Credit: Josh Long!)
	Embedded Server Examples: 
		spring-boot-starter-tomcat
		spring-boot-starter-jetty s
		pring-boot-starter-undertow

Monitor Applications using Spring Boot Actuator
add 
<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>

update application.properties
management.endpoints.web.exposure.include=*
exposes all the endpoints
management.endpoints.web.exposure.include=health,metrics
provided by actuator or http://localhost:8080/actuator

Monitor and manage your application in your production
	Provides a number of endpoints:
		beans - Complete list of Spring beans in your app
		health - Application health information 
		metrics - Application metrics
		mappings - Details around Request Mappings

Understanding Spring Boot vs Spring MVC vs Spring
Spring Boot vs Spring MVC vs Spring: What's in it? 
	Spring Framework: Dependency Injection
		@Component, @Autowired, Component Scan etc..
		Just Dependency Injection is NOT sufficient (You need other frameworks to build apps)
			Spring Modules and Spring Projects: Extend Spring Eco System
				Provide good integration with other frameworks (Hibernate/JPA, JUnit & Mockito for Unit Testing)

Spring MVC (Spring Module): Simplify building web apps and REST API 
	Building web applications with Struts was very complex
	@Controller, @RestController, @RequestMapping("/courses")
	
Spring Boot (Spring Project): Build PRODUCTION-READY apps QUICKLY
	Starter Projects - Make it easy to build variety of applications
	Auto configuration - Eliminate configuration to setup Spring, Spring MVC and other frameworks!
	Enable non functional requirements (NFRs): 
		Actuator: Enables Advanced Monitoring of applications
		Embedded Server: No need for separate application servers! 
		Logging and Error Handling
		Profiles and ConfigurationProperties
		

Managing App. Configuration using Profiles
Applications have different environments: Dev, QA, Stage, Prod, ...
Different environments need different configuration:
base on that application.properties will change as 
application-dev.properties
application-prod.properties
in this files we can configure different profiles base on the env






 */