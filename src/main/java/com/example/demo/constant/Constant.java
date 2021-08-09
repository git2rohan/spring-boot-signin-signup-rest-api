package com.example.demo.constant;

public class Constant {

	public static final String DELETE_USER_MESSAGE = "User has been deleted.";
	public static final String USER_NOT_FOUND_EXCEPTION = "User not found in database";
	public static final String USER_ALREADY_EXISTS_EXCEPTION = "User already exists in database.";

	public static final String LOGIN_CREDS_INVALID_EXCEPTION = "Entered username and password does not met.";
	public static final String LOGIN_USERNAME_ALREADY_EXISTS_EXCEPTION = "Entered username already exists. Please try with different username";
	public static final String LOGIN_USER_ALREADY_MAPPED_WITH_CREDS_EXCEPTION = "User already mapped with credentials.";
	public static final String LOGIN_USER_NOT_MAPPED_WITH_CREDS_EXCEPTION = "User field required.";
	public static final String LOGIN_USER_CANNOT_BE_UPDATED = "User cannot be updated. Please do not pass user object in body.";
	public static final String LOGIN_ID_DOES_NOT_EXISTS = "Login id does not exists in database.";
	public static final String LOGIN_ID_REQUIRED = "Login id is required for PUT call";
	public static final String LOGIN_USERNAME_REQUIRED = "Username required.";
	public static final String LOGIN_PASSWORD_REQUIRED = "Password required.";
}
