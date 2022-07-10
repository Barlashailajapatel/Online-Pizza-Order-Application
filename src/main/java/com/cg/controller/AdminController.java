package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Dao.AdminDao;
import com.cg.model.Admin;


@RestController
public class AdminController {
	@Autowired
	private AdminDao adminDao;
	
	

	@PostMapping(path = "/createAdmin")
	public Admin createAdmin(@Valid@RequestBody Admin admin)
	{
		return adminDao.addAdmin(admin);
	}
	@DeleteMapping(path="deleteUser/{userId}")
	public void deleteAdmin(@PathVariable int adminId){
		System.out.println("User deleted sucessfully");
		adminDao.deleteAdmin(adminId);
	
}
}
