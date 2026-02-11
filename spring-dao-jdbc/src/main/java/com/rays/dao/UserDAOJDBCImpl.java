package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImpl implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource=null;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	public long nextPk() {
		// TODO Auto-generated method stub
		String sql="select max(id) from st_user";
		Long maxId=jdbcTemplate.queryForObject(	sql, Long.class);
		if(maxId==null) {
			return 1;//This condition executes when table is empty
		}
		
		return maxId+1;
	}

	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		long pk=nextPk();
		String sql="insert into st_user values(?,?,?,?,?)";
		int i=jdbcTemplate.update(sql, pk,dto.getFirstName(),dto.getLastName(),dto.getLogin(),dto.getPassword());
		System.out.println("Record added: "+i);
		return i;
	}

	public long update(UserDTO dto) {
		// TODO Auto-generated method stub
		String sql="update st_user set first_name=?,last_name=?,login=?,password=? where id=?";
		int i=jdbcTemplate.update(sql,dto.getFirstName(),dto.getLastName(),dto.getLogin(),dto.getPassword(),dto.getId());
		System.out.println("Record updated successfully: "+i);
		return i;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		String sql="delete from st_user where id=?";
		int i=jdbcTemplate.update(sql,id);
		System.out.println("Record deleted successfully");
		
	}
	
	
	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		String sql="select * from st_user where login=?";
		Object[] params= {login};
		UserDTO user=jdbcTemplate.queryForObject(sql, params, new UserMapper());
		return user;
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		String sql="select * from st_user where login=? and password=?";
		Object[] params= {login,password};
		UserDTO dto=jdbcTemplate.queryForObject(sql, params, new UserMapper());
		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select * from st_user where 1=1");
		if(dto!=null) {
			if(dto.getFirstName()!=null && dto.getFirstName().length()>0) {
				sql.append("and first_name like '"+dto.getFirstName()+"'%");
			}
			if(dto.getLastName()!=null && dto.getLastName().length()>0) {
				sql.append("and last_name like '"+dto.getLastName()+"'%");
			}
			if(dto.getLogin()!=null && dto.getLogin().length()>0) {
				sql.append("and login="+dto.getLogin());
			}
			if(dto.getPassword()!=null && dto.getPassword().length()>0) {
				sql.append("and password ="+dto.getPassword());
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			sql.append(" limit "+pageNo+","+pageSize);
		}
		List<UserDTO> list=jdbcTemplate.query(sql.toString(),new UserMapper());
		return list;
	}

	

}
