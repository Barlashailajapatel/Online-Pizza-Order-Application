package com.cg.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
	@Transactional
	@Modifying
	@Query(value = "update  Customer b set b.customerName =?1, b.customerAddress=?2,b.customerMobile=?3,b.customerEmail=?4 where b.customerId=?5")
	public int updateCustomerById(String customerName,String customerAddress, long customerMobile,String customerEmail);




}


