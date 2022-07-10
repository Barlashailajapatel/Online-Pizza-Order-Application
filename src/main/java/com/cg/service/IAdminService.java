package com.cg.service;

import com.cg.model.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin);
	public void deleteAdmin(int adminId);
	public String getAdminName(int adminId);
	public String getAdminPassword(int adminId);
	//public Admin signIn(Admin user);
	//public Admin signOut(Admin user);
}
