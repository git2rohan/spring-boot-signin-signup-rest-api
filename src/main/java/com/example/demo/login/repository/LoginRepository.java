package com.example.demo.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.login.Login;
import com.example.demo.user.User;

public interface LoginRepository extends JpaRepository<Login, Integer>{

	public Login findByUserNameAndPassword(String username, String password);
	
	public Login findByUserName(String username);
	
	@Query("select l from Login l where l.user=?1")
	public Login findByUser(User user);
}
