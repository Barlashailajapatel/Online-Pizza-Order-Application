package com.cg.exception;


	public class CustomerCreationException extends Exception {
		public CustomerCreationException()
		{
			super();
		}
		public CustomerCreationException(String errorMsg)
		{
			super(errorMsg);
		}
	}

