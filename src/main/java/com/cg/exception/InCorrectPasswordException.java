package com.cg.exception;


	public class InCorrectPasswordException extends Exception {
		public  InCorrectPasswordException() {
			
		}
		public InCorrectPasswordException(String msg) {
			super(msg);
		}

}
