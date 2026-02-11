package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDAOInt {
	
	public long nextPk();
	
	public long add(UserDTO dto);
	
	public long update(UserDTO dto);
	
	public void delete(long id);
	
	public UserDTO findByLogin(String login);
	
	public UserDTO authenticate(String login,String password);
	
	public List search(UserDTO dto,int pageNo,int pageSize);
}
