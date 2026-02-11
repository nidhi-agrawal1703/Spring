package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory=null;
		
	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return (Long)session.save(dto);
	}

	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(dto);
	}

	public void delete(long pk) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		UserDTO dto=findByPk(pk);
		session.delete(dto);
	}

	public UserDTO findByPk(long pk) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		UserDTO dto=session.get(UserDTO.class, pk);
		return dto;
	}

	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		List list=criteria.list();
		UserDTO dto=null;
		if(list.size()==1) {
			dto=(UserDTO)list.get(0);
		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));
		List list=criteria.list();
		UserDTO dto=null;
		if(list.size()==1) {
			dto=(UserDTO)list.get(0);
		}
		return dto;
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(UserDTO.class);
		if(dto!=null) {
			if(dto.getFirstName()!=null && dto.getFirstName().length()>0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName()+"%"));
			}
			if(dto.getLastName()!=null && dto.getLastName().length()>0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName()+"%"));
			}
			if(dto.getLogin()!=null && dto.getLogin().length()>0) {
				criteria.add(Restrictions.eq("login", dto.getLogin()));
			}
			if(dto.getPassword()!=null && dto.getPassword().length()>0) {
				criteria.add(Restrictions.eq("password", dto.getPassword()));
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list=criteria.list();
		return list;	}

}
