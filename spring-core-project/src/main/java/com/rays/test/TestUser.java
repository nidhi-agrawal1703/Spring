package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestUser {
	
	public static void main(String[] args) {
		
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("user.xml"));
		
		User dto1=(User)factory.getBean("user");
		System.out.println(dto1.getName());
		System.out.println(dto1.getAddress());
		
		System.out.println("------------------");
		
		User dto2=(User)factory.getBean("user1");
		System.out.println("Constructor");
		System.out.println(dto2.getName());
		System.out.println(dto2.getAddress());
	}
}
