package com.Niit.Dao;

import java.util.List;

import com.Niit.model.User;

public interface UserDAO {

	void registerUser(User user);
	boolean isEmailUnique(String email);
	User login(User user);
	void update(User validUser);
	User getUser(String email);
	void updateUser(User user);
	List<User> searchUser(String name);
}
