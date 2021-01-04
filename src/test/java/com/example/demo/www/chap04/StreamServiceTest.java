package com.example.demo.www.chap04;

import static org.junit.jupiter.api.Assertions.*;
import static java.util.Arrays.asList;
import org.junit.jupiter.api.Test;

class StreamServiceTest {
	StreamService ss = new StreamService();
	
	@Test
	public void bookTitle() {
		assertTrue(asList("Java8", "Lambdas", "In", "Action").equals(ss.bookTitle()));
	}

	@Test
	public void menu() {
		assertEquals(9, ss.menu().size());
	}
	
	@Test
	public void filterByWeight() {
		assertTrue(asList(new Dish("pork", false, 800, Type.MEAT)).equals(ss.filterByWeight(700)));
	}
}
