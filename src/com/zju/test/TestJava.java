package com.zju.test;

public class TestJava {
	public static void main(String[] args) {
		
		Gender g = Gender.valueOf(Gender.class, "MALE");
		System.out.println(g.getName());
		System.out.println(Gender.FEMALE.getName());
	}
}


