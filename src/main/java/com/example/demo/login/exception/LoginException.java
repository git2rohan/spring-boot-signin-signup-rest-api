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
	
	
	@ExceptionHandler(value=LoginInvalidLoginIdException.class)
	public ResponseEntity<Object> loginInvalidLoginIdException(LoginInvalidLoginIdException exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_ID_DOES_NOT_EXISTS, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=LoginIdRequiredException.class)
	public ResponseEntity<Object> loginIdRequiredException(LoginIdRequiredException exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_ID_REQUIRED, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value=LoginUserRequired.class)
	public ResponseEntity<Object> loginUserIsNotMappedException(LoginUserRequired exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_USER_NOT_MAPPED_WITH_CREDS_EXCEPTION, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value=LoginUsernameRequiredException.class)
	public ResponseEntity<Object> loginUsernameRequiredException(LoginUsernameRequiredException exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_USERNAME_REQUIRED, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value=LoginPasswordRequiredException.class)
	public ResponseEntity<Object> loginPasswordRequiredException(LoginPasswordRequiredException exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_PASSWORD_REQUIRED, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(value=LoginUserCannotBeUpdatedException.class)
	public ResponseEntity<Object> loginUserCannotBeUpdatedException(LoginUserCannotBeUpdatedException exception)
	{
		return new ResponseEntity<>(Constant.LOGIN_USER_CANNOT_BE_UPDATED, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
