package com.example.demo.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.common.CommonUtils;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private int gender;
	private LocalDateTime signUpAt = new CommonUtils().get_IST_TimeNow();;
	
	
	public LocalDateTime getSignUpAt() {
		return signUpAt;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	
}
