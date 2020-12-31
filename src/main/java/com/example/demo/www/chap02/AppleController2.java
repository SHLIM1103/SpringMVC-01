package com.example.demo.www.chap02;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class AppleController2 {	
	public static void main(String... args) {
		AppleService as = new AppleService();
		List<Apple> ls = Arrays.asList(
				new Apple[]{new Apple(80, Color.GREEN),
						new Apple(90, Color.GREEN),
						new Apple(100, Color.RED),
						new Apple(110, Color.RED),
						new Apple(120, Color.RED)});
		List<String> ls2 = Arrays.asList(
				new String[] {"a", "b", "c", "d", "e"}
				);
		
		// 명령형
		ls.stream()
			.map(Apple::toString)
			.limit(3)
			.collect(toList())
			.forEach(System.out::println);
//		for(Apple a : ls) {
//			System.out.println(a.toString());
//		}
//		System.out.println();
		
		// 선언형
		
//		Stream<String> s = ls2.stream();
//		s.forEach(System.out::print);
		
	}
}
