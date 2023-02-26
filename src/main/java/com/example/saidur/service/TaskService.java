package com.example.saidur.service;

import com.example.saidur.model.Task;
import com.example.saidur.model.User;

import java.util.List;

public interface TaskService {
	
	List<Task> getAllTasks();
	Task getTaskById(Long id);
	Task saveTask(Task task);
	String deleteTask(Long id);
	Task updateTask(Long id, Task task);


}
