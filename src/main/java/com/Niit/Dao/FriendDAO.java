package com.Niit.Dao;

import java.util.List;

import com.Niit.model.Friend;
import com.Niit.model.User;

public interface FriendDAO {
	
    List<User> suggestedUsers(String email);
	
	void addFriend(Friend friend);

	List<Friend> pendingRequests(String email);

	void acceptRequest(Friend request);

	void deleteRequest(Friend request);

	public List<Friend> listOfFriends(String email);

}
