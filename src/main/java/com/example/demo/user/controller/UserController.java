package com.example.demo.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;
import com.example.demo.user.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers()
	{
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId)
	{
		return ResponseEntity.ok().body(userService.getUserById(userId));
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		return ResponseEntity.ok().body(userService.saveUser(user));
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		return ResponseEntity.ok().body(userService.updateUser(user));
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<String> deleteUser(@RequestBody User user)
	{
		return ResponseEntity.ok().body(userService.deleteUser(user));
	}
}
