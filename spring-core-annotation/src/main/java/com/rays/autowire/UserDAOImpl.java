package com.rays.autowire;

import org.springframework.stereotype.Repository;

@Repository("userDao") //@Repository annotation is used to create DAO(CRUD) layer and also create bean
public class UserDAOImpl implements UserDAOInt  {

	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Add method of UserDAOImpl");
	}

}
