package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Used to create service layer and also creates bean
public class UserService {
	
	@Autowired //Injects dependency by type
	private UserDAOInt userDao;
	
	public void testAdd() {
		userDao.add();
	}
	
}
