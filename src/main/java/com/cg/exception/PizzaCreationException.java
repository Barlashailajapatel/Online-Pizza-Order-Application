package com.cg.exception;


public class PizzaCreationException extends Exception {
	public PizzaCreationException()
	{
		super();
	}
	public PizzaCreationException(String errorMsg)
	{
		super(errorMsg);
	}

}
