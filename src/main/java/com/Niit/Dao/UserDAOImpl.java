package com.Niit.Dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Niit.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(){
		System.out.println("UserDAOImpl");
	}
	public void registerUser(User user) {

		Session session= sessionFactory.getCurrentSession();
		session.save(user);
	}
	public boolean isEmailUnique(String email) {
		
		Session session= sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, email);
		if(user==null)
			return true;
		else
			return false;
	}
	public User login(User user) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User Where email=? and password=?");
		query.setString(0,user.getEmail());
		query.setString(1,user.getPassword());
		
		return (User)query.uniqueResult();
	}
	public void update(User validUser) {
		Session session=sessionFactory.getCurrentSession();
		session.update(validUser);
		
	}
	public User getUser(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User) session.get(User.class, email);
		return user;
	}
	public void updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
	}

}
