package com.example.demo.www.chap05;

import static org.junit.jupiter.api.Assertions.*;
import static java.util.Arrays.asList;
import org.junit.jupiter.api.Test;

class MappingServiceTest {
	MappingService ms = new MappingService();
	
	@Test
	void testMyMap() {
		assertTrue(asList("pork", "beef", "chicken", "french fries", "rice", "season fruit", "pizza", "prawns", "salmon").equals(ms.myMap()));
	}

	@Test
	void testMyMap2() {
		assertTrue(asList(5, 5).equals(ms.myMap2()));
	}

	@Test
	void testMyFlatMap() {
		assertTrue(asList("H", "e", "l", "o", "W", "r", "d").equals(ms.myFlatMap()));
	}

}
