package com.Niit.Dao;

import java.util.List;

import com.Niit.model.BlogPost;

public interface BlogPostDAO {

	void addBlogPost(BlogPost blogPost);
	List<BlogPost> listOfBlogs(int approved);
	BlogPost getBlog(int id);
}
