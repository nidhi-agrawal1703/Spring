package com.rays.test;

public class TestUser1 {
	
	public static void main(String[] args) {
		
		User user=new User();
		user.setName("Neha");
		user.setAddress("Bhopal");
		System.out.println(user.getName());
		System.out.println(user.getAddress());
		
		System.out.println("------------------");
		
		User user1=new User("Constructor name","Constructor address");
		System.out.println(user1.getName());
		System.out.println(user1.getAddress());
	}
}
