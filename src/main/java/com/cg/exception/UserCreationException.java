package com.cg.exception;



public class UserCreationException extends Exception {
	public UserCreationException()
	{
		super();
	}
	public UserCreationException(String errorMsg)
	{
		super(errorMsg);
	}
}


