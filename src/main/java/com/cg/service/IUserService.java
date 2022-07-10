package com.cg.service;

import com.cg.exception.InCorrectPasswordException;

import com.cg.exception.SignInException;
import com.cg.exception.UserCreationException;
import com.cg.model.User;

public interface IUserService {
public User addNewUser(User user) throws UserCreationException, InCorrectPasswordException;
public User signIn(User user) throws SignInException;
public User signOut(User user);
boolean forgetPassword(String oldPassword, String newPassword);
}
