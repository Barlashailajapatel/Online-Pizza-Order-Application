package com.cg.controller;

import java.net.http.HttpHeaders;
import java.util.Scanner;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Dao.AdminDao;
import com.cg.Dao.UserDao;
import com.cg.exception.InCorrectPasswordException;
import com.cg.exception.PizzaAlreadyExists;
import com.cg.exception.PizzaCreationException;
import com.cg.exception.SignInException;
import com.cg.exception.UserCreationException;
import com.cg.model.Admin;
import com.cg.model.Pizza;
import com.cg.model.User;


@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
UserDao userdao;
	@Autowired
	AdminDao admindao;
	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(UserDao.class);
	
	
	
	@PostMapping("/addnewUser") // create user
	public User createUser(@Valid@RequestBody User user) throws InCorrectPasswordException, UserCreationException {
		logger.info("added successfully!");
		logger.info(user.getUserName() + " " + user.getUserPassword());
		return userdao.addNewUser(user);

	}
	@PutMapping("/login") 
	public User signin(@Valid@RequestBody User user) throws SignInException {
		System.out.println("user signedin ");
		return userdao.signIn(user);

	}
	@PutMapping("/signOut") 
		public User signOut(@Valid@RequestBody User user) {
			return userdao.signOut(user);
		}
		@PutMapping("/forget")
		public boolean forgetPassword(@Valid@PathVariable String oldPassword, @PathVariable String newPassword) {

			return userdao.forgetPassword(oldPassword, newPassword);
		}
		
	}






