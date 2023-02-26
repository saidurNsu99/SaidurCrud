package com.example.saidur.service;

import com.example.saidur.model.Task;
import com.example.saidur.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired //inject repository dependency
	TaskRepository taskRepository;
	
	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task); //save Task
	}



	@Override
	public Task getTaskById(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		if(task.isPresent()) return task.get();
		return null;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<Task>(); //create list of Tasks variable
		taskRepository.findAll().forEach(task ->tasks.add(task)); // keep each task in tasks list
		return tasks;
	}
	
	@Override
	public Task updateTask(Long id, Task task) {
		Optional<Task> taskById = taskRepository.findById(id);
		
		if(taskById.isPresent()) {
			Task updatedTask = taskById.get();

			updatedTask.setId(task.getId());
			updatedTask.setDescription(task.getDescription());
			updatedTask.setCompleted(task.getCompleted());
			updatedTask.setDuedate(task.getDuedate());
			updatedTask.setUser(task.getUser());
			
			return taskRepository.save(updatedTask);
		}
		
		return null;
	}

	@Override
	public String deleteTask(Long id) {
		taskRepository.deleteById(id); //delete task by id
		return "id" + id + "is deleted successfully"; 
	}
}
