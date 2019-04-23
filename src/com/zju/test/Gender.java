package com.zju.test;

public enum Gender {
	
	MALE("ÄÐ"),FEMALE("Å®");
	
	private final String name;
	private Gender(String name) {
		this.name = name;	
	}
	public String getName() {
		return this.name;
	}
}
