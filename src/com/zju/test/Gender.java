package com.zju.test;

public enum Gender {
	
	MALE("��"),FEMALE("Ů");
	
	private final String name;
	private Gender(String name) {
		this.name = name;	
	}
	public String getName() {
		return this.name;
	}
}
