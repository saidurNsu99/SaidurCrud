package com.example.saidur.controller;

import java.util.List;

import com.example.saidur.model.Task;
import com.example.saidur.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.saidur.model.User;
import com.example.saidur.service.UserService;

import static org.aspectj.util.LangUtil.isEmpty;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	TaskService taskService;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PostMapping("/users/{userId}/tasks")
	public Task saveUser(@RequestBody Task task) {
		return taskService.saveTask(task);
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
	 	return userService.getAllUsers();
	}

	@GetMapping("/users/{userId}/tasks")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}

	@GetMapping("/users/{userId}/tasks?completed")
	public Boolean getCompleted(){
		if ( isEmpty(taskService.getAllTasks())){
			return  true;
		};
		return false;
	}
	
	@PutMapping("/users/{userId}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@PutMapping("/users/{userId}/task/{taskId}")
	public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
		return taskService.updateTask(id, task);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return userService.deleteUser(id);
	}

	@DeleteMapping("/users/{userId}/tasks/{TaskId}")
	public String deleteTask(@PathVariable("TaskId") Long id) {
		return taskService.deleteTask(id);
	}

}
