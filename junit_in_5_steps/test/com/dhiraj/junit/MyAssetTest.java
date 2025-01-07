package com.dhiraj.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssetTest {

	List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");
	
	@Test
	void testAsserts() {
		boolean test = todos.contains("AWS");//Result
		boolean test2 = todos.contains("GCP");//Result
		
//		assertEquals(true, test);
		assertEquals(true, test, "Should contains AWS");		// can also pass message optional
//		assertTrue(test);
		assertTrue(test, "Should contains AWS");;
		assertFalse(test2);
		
		//assertNull,assertNotNull
		
		assertArrayEquals(new int[] {1,2}, new int[] {2, 1});
		
		assertEquals(3, todos.size());		
	}

}
