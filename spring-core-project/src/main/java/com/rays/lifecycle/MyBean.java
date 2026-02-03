package com.rays.lifecycle;

public class MyBean {
	
	public void init() {
		System.out.println("MyBean is created");
	}
	public void cleanup() {
		System.out.println("MyBean container is closed");
	}
}
