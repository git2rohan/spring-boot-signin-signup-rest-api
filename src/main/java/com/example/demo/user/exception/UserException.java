package com.example.demo.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.user.constant.Constant;

@ControllerAdvice
public class UserException {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(UserNotFoundException exception)
	{
		return new ResponseEntity<>(Constant.USER_NOT_FOUND_EXCEPTION, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserAlreadyExistsException.class)
	public ResponseEntity<Object> userAlreadyExistsException(UserAlreadyExistsException exception)
	{
		return new ResponseEntity<>(Constant.USER_ALREADY_EXISTS_EXCEPTION, HttpStatus.CONFLICT);
	}
}
