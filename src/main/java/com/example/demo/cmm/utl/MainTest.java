package com.example.demo.cmm.utl;

public class MainTest {
	public static void main(String[] args) {
		DummyGenerator dg = new DummyGenerator();
		System.out.println(dg.makeName());
		System.out.println(dg.makeBirthday());
		System.out.println(dg.makeNumber());
		System.out.println(dg.makeUserId());
		System.out.println(dg.makeSubject());
		System.out.println(dg.makeEmail());
	}
}
