package com.cg.service;

import java.util.List;

import com.cg.exception.CustomerAlreadyExists;
import com.cg.exception.CustomerCreationException;
import com.cg.exception.NoSuchCustomerException;
import com.cg.model.Customer;


public interface ICustomerService {
	
	public Customer addCustomer(Customer c)throws CustomerCreationException,CustomerAlreadyExists;
	public List<Customer> viewCustomer();
	public Customer deleteCustomer(long customerId) throws NoSuchCustomerException;
	public Customer viewCustomer(long customerId) throws NoSuchCustomerException;
	public Customer updateCustomer(Customer c) throws NoSuchCustomerException;
	

}
