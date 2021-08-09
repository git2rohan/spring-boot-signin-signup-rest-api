package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.Login;
import com.example.demo.login.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public Login doLogin(@RequestBody Login login)
	{
		return loginService.doLogin(login);
	}
	
	@GetMapping("/login/all")
	public List<Login> getLogginDetails()
	{
		return loginService.getLogginDetails();
	}
	
	@PostMapping("/login")
	public Login saveLogin(@RequestBody Login login)
	{
		return loginService.saveLogin(login);
	}
	
	@PutMapping("/login")
	public Login updateLoginDetails(@RequestBody Login login)
	{
		return loginService.updateLoginDetails(login);
	}
}
