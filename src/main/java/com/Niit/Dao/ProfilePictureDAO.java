package com.Niit.Dao;

import com.Niit.model.ProfilePicture;

public interface ProfilePictureDAO {
	
	void uploadProfilePicture(ProfilePicture profilePicture);
	ProfilePicture getImage(String email);
}
