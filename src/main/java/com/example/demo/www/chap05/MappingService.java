package com.example.demo.www.chap05;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class MappingService{
    // map
	public List<String> myMap() {
	    return MyDish.menu
	    	.stream()
	        .map(MyDish::getName)
	        .collect(toList());
	}
	
    // map
	public List<Integer> myMap2() {
	    return Arrays.asList("Hello", "World").stream()
	        .map(String::length)
	        .collect(toList());
	}
	
    // flatMap
	public List<String> myFlatMap() {
	    return Arrays.asList("Hello", "World")
	    	.stream()
	        .flatMap((String line) -> Arrays.stream(line.split("")))
	        .distinct()
	        .collect(toList());
	}
	
	// flatMap
	public List<int[]> myFlatMap2() {
	    return Arrays.asList(1,2,3,4,5).stream()
	    		.flatMap((Integer i) -> Arrays.asList(6,7,8).stream()
	            .map((Integer j) -> new int[]{i, j})
	    				)
	    		.filter(pair -> (pair[0] + pair[1]) % 3 == 0)
	    		.collect(toList());
	}
}