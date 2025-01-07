package com.dhiraj.junit;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {
	
	// there is not guarantee which test will run first like 
	// we can't guranteed that test1 will run first then test2 then test3
	// but beforAll will run before each test --> to make setup before each step
	// and afterAll will run after each test --> to make cleanup after each step
	// before Each and afterEach will execute for each test irrespective the test fails or pass
	
	// common setup to do for all the tests
	// beforeAll, aftetAll, they should be static, since they are class level methods

	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("BeforeEach");
	}

	@Test
	void test1() {
		System.out.println("test1");
	}

	@Test
	void test2() {
		fail();
		System.out.println("test2");		// won't execute coz it will return because of failure
	}

	@Test
	void test3() {
		System.out.println("test3");
	}

	@AfterEach
	void afterEach() {
		System.out.println("AfterEach");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}

}
