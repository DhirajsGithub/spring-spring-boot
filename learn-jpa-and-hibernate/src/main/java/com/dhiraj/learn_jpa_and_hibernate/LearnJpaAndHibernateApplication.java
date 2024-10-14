package com.dhiraj.learn_jpa_and_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnJpaAndHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnJpaAndHibernateApplication.class, args);
	}

}


/*
 step 1 : setting up a new spring boot project with dependencies of
 jdbc, jpa, spring web, h2-database
 
 step 2 : launching up h2-console and creating course Table
 in application.properties
 spring.h2.console.enabled=true
 restart the project
 we will get url=jdbc:h2:mem:ed88c53d-c70d-4e8d-993a-f8b9c6afc8f0 in console
 we can rename the url as 
 spring.datasource.url=jdbc:h2:mem:testdb
 create a schema.sql file in resources
 
 step 3 : getting started with spring dbbc
 CRUD using sql 
 
 step 4 : inserting hardcode data using spring Jdbc
 
 step 5 : querying data using spring jdbc
 
 step 6 : started with jpa and entity manager
 
 step 7 : 

*/









