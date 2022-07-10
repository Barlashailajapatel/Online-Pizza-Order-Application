package com.cg;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.exception.CustomerIdNotFoundException;
import com.cg.exception.ErrorMessage;
import com.cg.exception.InCorrectPasswordException;
import com.cg.exception.InvalidCouponOperationException;
import com.cg.exception.PizzaIdNotFoundException;
import com.cg.exception.SignInException;



@ControllerAdvice
public class GlobalExceptionHandler {




	@ExceptionHandler(SignInException.class)
	public @ResponseBody ErrorMessage checksSignInExceptionInfo(SignInException e,HttpServletRequest req) {
		
		
		//error info class is from exception package
		ErrorMessage erinfo = new ErrorMessage(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	@ExceptionHandler(InCorrectPasswordException.class)
	public @ResponseBody ErrorMessage checksInCorrectPasswordInfo(InCorrectPasswordException e,HttpServletRequest req) {
		
		
		
		ErrorMessage erinfo = new ErrorMessage(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
	
	
	@ExceptionHandler(PizzaIdNotFoundException.class)
	public @ResponseBody ErrorMessage checkNoIdFoundExceptionInfo(PizzaIdNotFoundException e,HttpServletRequest req) {
		 
		ErrorMessage erinfo = new ErrorMessage(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	} 
	

	
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public @ResponseBody ErrorMessage checkNoIdFoundExceptionInfo(CustomerIdNotFoundException e,HttpServletRequest req) {
		 
		ErrorMessage erinfo = new ErrorMessage(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	} 
	
	@ExceptionHandler(InvalidCouponOperationException.class)
	public ResponseEntity<Object> checkValidation(MethodArgumentNotValidException e,HttpServletRequest req) {
		 
		ErrorMessage erinfo = new ErrorMessage(LocalDateTime.now(),e.getMessage());
		 System.out.println(e.getBindingResult().toString());
		 return new ResponseEntity<Object>(erinfo,HttpStatus.BAD_REQUEST);
		 
	}
	
	/*	@ExceptionHandler(InvalidMinCostException.class)
	public @ResponseBody ErrorInfo checksInvalidMinCostExceptionInfo(InvalidMinCostException e,HttpServletRequest req) {
		
		
		
		ErrorInfo erinfo = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}*/
}

