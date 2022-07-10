package com.cg.Dao;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.cg.model.Admin;
import com.cg.repository.IAdminRepository;
import com.cg.service.IAdminService;

	



	@Service
	public class AdminDao  implements IAdminService{

		@Autowired
		IAdminRepository adminRepos;
		@Override
		public Admin addAdmin(Admin admin) {
			
			return adminRepos.save(admin);
		}

		@Override
		public void deleteAdmin(int adminId) {
			// TODO Auto-generated method stub
			adminRepos.delete(adminRepos.getById(adminId));
		}

		@Override
		public String getAdminName(int adminId) {
			// fetching admin user name
			return adminRepos.getAdminName(adminId);
		}

		@Override
		public String getAdminPassword(int adminId) {
			// fetching admin passsword
			return adminRepos.getAdminPassword(adminId);
		}

	}

		

	