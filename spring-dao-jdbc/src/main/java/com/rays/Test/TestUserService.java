package com.rays.Test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("testUserService")
public class TestUserService {
	
	@Autowired
	public UserService service=null;
	
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TestUserService test=(TestUserService)context.getBean("testUserService");
		
		//test.testAdd();
		//test.testUpdate();
		//test.testDelete(2);
		//test.testFindByLogin();
		//test.testAuthenticate();
		test.testSearch();
	}
	
	public void testAdd() {
		UserDTO dto=new UserDTO();
		dto.setFirstName("Nidhi");
		dto.setLastName("Agrawal");
		dto.setLogin("nidhi.agrawal1703@gmail.com");
		dto.setPassword("123");
		service.add(dto);
	}
	
	public void testUpdate() {
		UserDTO dto=new UserDTO();
		dto.setFirstName("Yash");
		dto.setLastName("Agrawal");
		dto.setLogin("yash.agrawal@gmail.com");
		dto.setPassword("123");
		dto.setId(1);
		service.update(dto);
	}
	
	public void testDelete(long id) {
		service.delete(id);
	}
	
	public void testFindByLogin() {
		UserDTO dto=new UserDTO();
		//dto.setLogin("yash.agrawal@gmail.com");
		dto=service.findByLogin("yash.agrawal@gmail.com");
		System.out.println("First Name: "+dto.getFirstName());
		System.out.println("Last Name: "+dto.getLastName());
		System.out.println("Login: "+dto.getLogin());
		System.out.println("Password: "+dto.getPassword());
	}
	
	public void testAuthenticate() {
		UserDTO dto=new UserDTO();
		dto=service.authenticate("nidhi.agrawal1703@gmail.com", "123");
		System.out.println("First Name: "+dto.getFirstName());
		System.out.println("Last Name: "+dto.getLastName());
		System.out.println("Login: "+dto.getLogin());
		System.out.println("Password: "+dto.getPassword());
	}
	
	public void testSearch() {
		UserDTO dto;
		List<UserDTO> list=service.search(null, 1, 5);
		Iterator it=list.iterator();
		while(it.hasNext()){
			dto=(UserDTO)it.next();
			System.out.println("First Name: "+dto.getFirstName());
			System.out.println("Last Name: "+dto.getLastName());
			System.out.println("Login: "+dto.getLogin());
			System.out.println("Password: "+dto.getPassword());
		}
	}
}
