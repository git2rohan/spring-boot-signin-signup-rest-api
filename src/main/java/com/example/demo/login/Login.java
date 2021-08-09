package com.example.demo.login;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.user.User;

@Entity
public class Login {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true) //It does not work when u have already created tables
	private String userName;
	private String password;
	private LocalDateTime lastLoggedIn;
	
	@OneToOne
	@JoinColumn(name="userId", unique = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getLastLoggedIn() {
		return lastLoggedIn;
	}
	public void setLastLoggedIn(LocalDateTime lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}
	
	
}
