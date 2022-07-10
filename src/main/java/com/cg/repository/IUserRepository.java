package com.cg.repository;


	
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.User;


@Repository
public interface IUserRepository  extends JpaRepository<User, Integer> {


	@Query(value= " select u.user_name from customer_table c ,user_table u where c.user_user_id=?1", nativeQuery=true)
	public String getUserName(int userId);
	@Query(value=" select u.user_password from customer_table c ,user_table u where c.user_user_id=?1", nativeQuery=true)
	public String getUserPassword(int userId);
	@Transactional
	@Modifying
	@Query(value="UPDATE u.user_table SET user_password = ?1 WHERE user_password=?2", nativeQuery=true)
	
	public int UpdatePassword(String newPassword, String oldPassword);
	
	
	//public User findByPassword(String oldPassword);
	

}