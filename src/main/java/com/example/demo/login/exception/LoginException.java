package com.example.demo.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.user.constant.Constant;

@ControllerAdvice
public class LoginException {

	@ExceptionHandler(value=LoginCredentialsInvalidException.class)
	public ResponseEntity<Object> loginCredentialsInvalidException(LoginCredentialsInvalidException exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_CREDS_INVALID_EXCEPTION, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=LoginUserNameAlreadyExistsException.class)
	public ResponseEntity<Object> loginUserNameAlreadyExistsException(LoginUserNameAlreadyExistsException exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_USERNAME_ALREADY_EXISTS_EXCEPTION, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=LoginUserAlreadyMappedWithCredentialsException.class)
	public ResponseEntity<Object> loginUserAlreadyMappedWithCredentialsException(LoginUserAlreadyMappedWithCredentialsException exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_USER_ALREADY_MAPPED_WITH_CREDS_EXCEPTION, HttpStatus.CONFLICT);
	}
	
}
