package com.Niit.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Niit.model.Job;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO{
	
	@Autowired
	private SessionFactory  sessionFactory;
	
	public JobDAOImpl() {
		System.out.println("JobDAOImpl");
	}

	public void addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(job);
	}

	@SuppressWarnings("unchecked")
	public List<Job> getAllJobs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		return query.list();
	}

	public Job getJob(int id) {
		 Session session=sessionFactory.openSession();
		 Job job=(Job)session.get(Job.class, id);
		 return job;
	}

}
