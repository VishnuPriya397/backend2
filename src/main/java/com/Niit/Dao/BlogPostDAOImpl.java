package com.Niit.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Niit.model.BlogPost;

@Repository
@Transactional
public class BlogPostDAOImpl implements BlogPostDAO {
	
public BlogPostDAOImpl(){
		
		System.out.println("BlogPostDAOImpl");
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addBlogPost(BlogPost blogPost) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogPost);

	}

	public List<BlogPost> listOfBlogs(int approved) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogPost where approved="+approved);
		List<BlogPost> blogs=query.list();
		return blogs;
	}

	public BlogPost getBlog(int id) {
		Session session=sessionFactory.getCurrentSession();
		BlogPost blogPost=(BlogPost)session.get(BlogPost.class, id);
		return blogPost;
	}

}
