package com.Niit.Dao;

import com.Niit.model.BlogPost;
import com.Niit.model.BlogPostLikes;

public interface BlogPostLikesDAO {
	
	BlogPostLikes hasUserLikedBlog(int blogid, String email);

	BlogPost updateLikes(int id, String email);

}
