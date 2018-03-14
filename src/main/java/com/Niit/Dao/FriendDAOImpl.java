package com.Niit.Dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Niit.model.User;

@Repository
@Transactional
public class FriendDAOImpl implements FriendDAO {

    public FriendDAOImpl(){
		
		System.out.println("FriendDAOImpl");
	}
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	public List<User> suggestedUsers(String email) {
		Session session=sessionFactory.openSession();
		SQLQuery sqlQuery=session.createSQLQuery("select * from user_table where email in " 
							 					+"(select email from user_table where email!=? "
												+"minus "
												+"(select fromId_email from friend where toId_email=?"
												+"union "
												+"select toId_email from friend where fromId_email=? ))");
		sqlQuery.setString(0, email);
		sqlQuery.setString(1, email);
		sqlQuery.setString(2, email);
		sqlQuery.addEntity(User.class);
		List<User> suggestedUsersList=sqlQuery.list();
		session.close();
		return suggestedUsersList;	
		
	}
}
