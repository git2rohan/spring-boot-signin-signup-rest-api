package com.example.demo.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.CommonUtils;
import com.example.demo.login.Login;
import com.example.demo.login.exception.LoginCredentialsInvalidException;
import com.example.demo.login.exception.LoginIdRequiredException;
import com.example.demo.login.exception.LoginInvalidLoginIdException;
import com.example.demo.login.exception.LoginPasswordRequiredException;
import com.example.demo.login.exception.LoginUserAlreadyMappedWithCredentialsException;
import com.example.demo.login.exception.LoginUserCannotBeUpdatedException;
import com.example.demo.login.exception.LoginUserNameAlreadyExistsException;
import com.example.demo.login.exception.LoginUserRequired;
import com.example.demo.login.exception.LoginUsernameRequiredException;
import com.example.demo.login.repository.LoginRepository;
import com.example.demo.user.exception.UserNotFoundException;
import com.example.demo.user.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;	
	@Autowired
	private UserRepository userRepository;
	
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
		if(login.getUserName()==null)
			throw new LoginUsernameRequiredException();
		else if(login.getPassword()==null)
			throw new LoginPasswordRequiredException();
		else if(login.getUser()==null)
			throw new LoginUserRequired();
		else 
			if(!userRepository.existsById(login.getUser().getId()))
				throw new UserNotFoundException();
			if(loginRepository.findByUser(login.getUser())!=null)
				throw new LoginUserAlreadyMappedWithCredentialsException();
			if(loginRepository.findByUserName(login.getUserName())!=null)
				throw new LoginUserNameAlreadyExistsException();
			
		return loginRepository.save(login);
	}

	public Login updateLoginDetails(Login login) 
	{
		if(login.getId()==0)
			throw new LoginIdRequiredException();
		else if(login.getUser()!=null)
			throw new LoginUserCannotBeUpdatedException();
		else
		{
			Boolean loginDetailsExists = loginRepository.existsById(login.getId());
			if(!loginDetailsExists)
				throw new LoginInvalidLoginIdException();
			else
			{
				Login loginDetails = loginRepository.findById(login.getId()).get();
				if(login.getUserName()!=null)
					if(loginRepository.findByUserName(login.getUserName())!=null)
						throw new LoginUserNameAlreadyExistsException();				
				if(login.getUserName()==null)
				{
					login.setUserName(loginDetails.getUserName());
				}
				if(login.getPassword()==null)
				{
					login.setPassword(loginDetails.getPassword());
				}
				if(login.getLastLoggedIn()==null)
				{
					login.setLastLoggedIn(loginDetails.getLastLoggedIn());
				}
				if(login.getUser()==null)
				{
					login.setUser(loginDetails.getUser());
				}
			}
		}
			
		return loginRepository.save(login);
	}

	public List<Login> getLogginDetails() {
		
		return loginRepository.findAll();
	}
}
