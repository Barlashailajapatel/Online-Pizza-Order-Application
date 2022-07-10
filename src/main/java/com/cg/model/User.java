package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="User_Table")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min=1)
private int userId;
	@NotBlank(message="adminName should not be blank")
private String userName;
	@NotNull(message="adminPassword should not be blank")
private String userPassword;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}

public User(int userId, String userName, String userPassword) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userPassword = userPassword;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

}