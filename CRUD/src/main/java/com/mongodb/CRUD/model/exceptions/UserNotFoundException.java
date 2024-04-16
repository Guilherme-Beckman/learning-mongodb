package com.mongodb.CRUD.model.exceptions;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		super("User not found on Database");
	}
}
