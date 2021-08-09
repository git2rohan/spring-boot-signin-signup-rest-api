package com.example.demo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.user.User;
import com.example.demo.user.exception.UserAlreadyExistsException;
import com.example.demo.user.exception.UserNotFoundException;
import com.example.demo.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers()
	{
		List<User> users = userRepository.findAll();
		if(users!=null)
			return users;
		throw new UserNotFoundException();
	}

	public User getUserById(int userId) 
	{	
		User user = userRepository.findById(userId).get();
		if(user!=null)
			return user;
		throw new UserNotFoundException();
	}

	public User saveUser(User user) 
	{
		if(userRepository.existsById(user.getId()))
			throw new UserAlreadyExistsException();
		return userRepository.save(user);	
		
	}

	public User updateUser(User user) 
	{
		if(userRepository.existsById(user.getId()))
			return userRepository.save(user);
		throw new UserNotFoundException();
	}

	public String deleteUser(User user) {
		if(userRepository.existsById(user.getId())) {
			userRepository.delete(user);
			return Constant.DELETE_USER_MESSAGE;
		}
		throw new UserNotFoundException();
		
	}
	
}
