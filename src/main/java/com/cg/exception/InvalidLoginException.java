package com.cg.exception;


	public class InvalidLoginException extends RuntimeException {
		
		
		public InvalidLoginException(String error)
		{
			super(error);
		}


}
