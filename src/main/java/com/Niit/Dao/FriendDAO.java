package com.Niit.Dao;

import java.util.List;

import com.Niit.model.User;

public interface FriendDAO {

	public List<User> suggestedUsers(String email);
	
}
