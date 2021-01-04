package com.example.demo.www.chap05;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuildingStreamsServiceTest {
	BuildingStreamsService bs = new BuildingStreamsService(); 
			
	@Test
	void testMyOf() {
		assertTrue(asList("Java 8", "Lambdas", "In", "Action").equals(bs.myOf()));
	}

	@Test
	void testMySum() {
		assertEquals(41, bs.mySum());
	}

	@Test
	void testMyIterator() {
		assertTrue(asList().equals(bs.myIterator()));
	}

	@Test
	void testMyFibonacci() {
		assertTrue(asList().equals(bs.myFibonacci()));
	}

	@Test
	void testMyFibonacci2() {
		assertTrue(asList().equals(bs.myFibonacci2()));
	}

}
