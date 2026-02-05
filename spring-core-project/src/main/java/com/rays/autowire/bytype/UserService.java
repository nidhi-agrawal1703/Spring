package com.rays.autowire.bytype;

public class UserService {
	
	private UserDAOInt userdaoInt;

	//Setter method is necessary to implement autowire bytype
	public void setUserdaoInt(UserDAOInt userdaoInt) {
		this.userdaoInt = userdaoInt;
	}
	
	public void testAdd() {
		userdaoInt.add();
	}
	
}
