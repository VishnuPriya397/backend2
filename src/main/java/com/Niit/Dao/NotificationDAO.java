package com.Niit.Dao;

import java.util.List;

import com.Niit.model.Notification;

public interface NotificationDAO {

	List<Notification> getNotificationNotViewed(String email);

	Notification getNotification(int id);

	void updateNotification(int id);
}
