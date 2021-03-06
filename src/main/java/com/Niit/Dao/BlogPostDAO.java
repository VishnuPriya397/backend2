package com.Niit.Dao;

import java.util.List;

import com.Niit.model.BlogComment;
import com.Niit.model.BlogPost;

public interface BlogPostDAO {

	void addBlogPost(BlogPost blogPost);
	List<BlogPost> listOfBlogs(int approved);
	BlogPost getBlog(int id);
	void approve(BlogPost blog);
	void reject(BlogPost blog,String rejectionReason);
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getAllBlogComments(int blogPostId);
	
}
