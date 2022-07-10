package com.cg.exception;


	public class OrderCreationException extends Exception {
		public OrderCreationException()
		{
			super();
		}
		public OrderCreationException(String errorMsg)
		{
			super(errorMsg);
		}
}