package com.dhiraj.learn_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMavenApplication.class, args);
	}

}

/*

What is Maven ? 
an open-source build automation tool that helps developers manage projects by building, publishing, and deploying them
Maven helps - 
	- create new project
	- manages dependencies and their version
	- build a JAR file
	- run your application locally in Tomcat or jetty or ...
	- run unit tests
	- deploy to test environment
	- and lot more

Exploring Project Object Model - pom.xml
1. Maven dependencies : Framework and libraries used in a project
	Ex: spring-boot-starter-web and spring-boot-starter-test
2. Parent Pom : spring-boot-starter-parent
	- dependency management : spring-boot-dependencies
	- Properties: java.version, plugins and configurations
3. Name of our project : groupId + artifactId
	- groupId: Similar to package name
	- artifactId: Similar to class name
	- Why is it important?
		So that ther projects use our new project

right click on project, run as maven build > Goals can be help:effective-pom, dependency:tree
Activity: help:effective-pom, dependency:tree

Exploring Maven Build Life Cycle
When we run a maven command, maven build life cycle is used
right click on package > run as > maven buil > goal (one of the below)
Build LifeCycle is a sequence of steps 
	validate
	compile
	test
	package 
	integration test 
	verify
	install 
	deploy

How does Maven Work?
Maven follows Convention over Configuration
	Pre defined folder structure
	Almost all Java projects follow Maven structure (Consistency)
Maven central repository contains (https://repo1.maven.org/maven2/) (https://repo.spring.io/ui/native/milestone) jars (and others) indexed
by artifact id and group id 
	Stores all the versions of dependencies
	repositories > repository
	pluginRepositories > pluginRepository
When a dependency is added to pom.xml, Maven tries to
download the dependency
	Downloaded dependencies are stored inside your maven local repository
	Local Repository : a temp folder on your machine where maven stores the jar and dependency files that are downloaded from Maven Repository.

Important Maven Commands
	mvn --version
	mvn compile: Compile source files
	mvn test-compile: Compile test files
	OBSERVCE CAREFULLY: This will also compile source files
	mvn clean: Delete target directory mvn test: Run unit tests
	mvn package: Create a jar
	mvn help:effective-pom
	mvn dependency:tree
to run the commands in eclipse
right click on package > run as > maven buil > goal (--version or compile or clean or ...)

How are Spring Releases Versioned?
Version scheme - MAJOR.MINOR.PATCH[-MODIFIER] 
	MAJOR: Significant amount of work to upgrade (10.0.0 to 11.0.0)
	MINOR: Little to no work to upgrade (10.1.0 to 10.2.0)
	PATCH: No work to upgrade (10.5.4 to 10.5.5)
	MODIFIER: Optional 
		modifier Milestones - M1, M2, .. (10.3.0-M1,10.3.0-M2)
		Release candidates - RC1, RC2, .. (10.3.0-RC1, 10.3.0-RC2) 
		Snapshots - SNAPSHOT
		Release - Modifier will be ABSENT (10.0.0, 10.1.0)
		
Example versions in order:
	10.0.0-SNAPSHOT, 10.0.0-M1, 10.0.0-M2, 10.0.0-RC1, 10.0.0-RC2, 10.0.0, ...

MY RECOMMENDATIONS: 
	Avoid SNAPSHOTs
	Use ONLY Released versions in PRODUCTION

 */