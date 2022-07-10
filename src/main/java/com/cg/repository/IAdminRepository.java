package com.cg.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	@Transactional
	@Modifying
	@Query(value= "select admin_name from admin_table where admin_id=?1", nativeQuery=true)
	public String getAdminName(int adminId);
	@Query(value="select admin_password from admin_table where admin_id=?1", nativeQuery=true)
	public String getAdminPassword(int adminId);
	

	
}


