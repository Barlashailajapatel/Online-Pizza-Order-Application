package com.cg.Dao;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.InCorrectPasswordException;
import com.cg.exception.InvalidLoginException;
import com.cg.exception.SignInException;
import com.cg.exception.UserCreationException;
import com.cg.model.User;
import com.cg.repository.IUserRepository;
import com.cg.service.IUserService;


@Service
public class UserDao implements IUserService {
	@Autowired
	IUserRepository userRepos;
	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(UserDao.class);
		@Override
	public User addNewUser(User user) throws UserCreationException, InCorrectPasswordException {

		User u = new User();
		
		//String regex = "^(?=.[0-9])" + "(?=.[a-z])(?=.[A-Z])" + "(?=.[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		//Pattern p = Pattern.compile(regex);
	//	java.util.regex.Matcher m = p.matcher(user.getUserPassword());

	//	if (m.matches()) {
		if (user!=null) {

			userRepos.save(user);
			return u;
		} else {
			
			System.out.println("password is in incorrect format");
			throw new InCorrectPasswordException("give correct password");
			 
	}
		}
	@Override
	public User signIn(User user) throws InvalidLoginException, SignInException {
		// TODO Auto-generated method stub
	int id = user.getUserId();
		Optional<User> uu = userRepos.findById(id);

		User u2 = uu.get();

		if (u2.getUserPassword().equals(user.getUserPassword()) && u2.getUserName().equals(user.getUserName())) {
			System.out.println("login successfull");
			return u2;
		} else {
			System.out.println("login incomplete");
			//throw new SignInException("login unsuccessful!");
    throw new SignInException("login unsuccessful");
		}

	}

	@Override
	public User signOut(User user) {
		int id = user.getUserId();
		Optional<User> u = userRepos.findById(id);
		User u1 = u.get();
		return u1 = null;
	}

	
		@Override
		public boolean forgetPassword(String oldPassword, String newPassword) {
			// TODO Auto-generated method stub
			int status=0;
			status=userRepos.UpdatePassword(newPassword,oldPassword);
			
			if (status>=1) {
				
				return true;
			} 
				//User ua = userRepos.findByPassword(oldPassword);
				// Optional<User> uu=repository.findById(password);
				//ua.setUserPassword(newPassword);
				return false;
			}
		}
				
			
			

	