package com.Niit.Dao;

import java.util.List;

import com.Niit.model.Job;

public interface JobDAO {

	void addJob(Job job);
	List<Job> getAllJobs();
	Job getJob(int id);
	
}
