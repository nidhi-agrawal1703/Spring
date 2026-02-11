package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="st_user")
public class UserDTO {

	@Id
	@GeneratedValue(generator="ncsPk")
	@GenericGenerator(name="ncsPk", strategy="native")
	@Column(name="id",unique=true,nullable=false)
	private long id;
	
	@Column(name="first_name",length=50)
	private String firstName;
	
	@Column(name="last_name",length=50)
	private String lastName;
	
	@Column(name="login",length=255)
	private String login;
	
	@Column(name="password",length=50)
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
