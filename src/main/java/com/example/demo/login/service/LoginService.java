package com.example.demo.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.CommonUtils;
import com.example.demo.login.Login;
import com.example.demo.login.exception.LoginCredentialsInvalidException;
import com.example.demo.login.exception.LoginUserAlreadyMappedWithCredentialsException;
import com.example.demo.login.exception.LoginUserNameAlreadyExistsException;
import com.example.demo.login.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public Login doLogin(Login login)
	{
		String username = login.getUserName();
		String password = login.getPassword();
		login = loginRepository.findByUserNameAndPassword(username, password);
		if(login!=null)
			login = updateLoginTime(login);
		else
			throw new LoginCredentialsInvalidException();
		return login;
	}
	
	public Login updateLoginTime(Login login)
	{
		login.setLastLoggedIn(new CommonUtils().get_IST_TimeNow());
		return loginRepository.save(login);
	}

	public Login saveLogin(Login login) 
	{
		if(loginRepository.findByUserName(login.getUserName())!=null)
			throw new LoginUserNameAlreadyExistsException();
		else if(loginRepository.findByUser(login.getUser())!=null)
			throw new LoginUserAlreadyMappedWithCredentialsException();
		return loginRepository.save(login);
	}

	public Login updateLoginDetails(Login login) 
	{
		
		return loginRepository.save(login);
	}

	public List<Login> getLogginDetails() {
		
		return loginRepository.findAll();
	}
}
