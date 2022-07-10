package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Dao.CustomerDao;
import com.cg.exception.CustomerAlreadyExists;
import com.cg.exception.CustomerCreationException;
import com.cg.exception.NoSuchCustomerException;
import com.cg.model.Customer;


@RestController
@RequestMapping("/api")
public class CustomerController {
	
	
	@Autowired
	CustomerDao dao;
	

		
	
	@PostMapping(path = "/customer/create")
	public Customer addCustomer(@Valid@RequestBody Customer customer) throws CustomerAlreadyExists, CustomerCreationException
	{
		Customer b=dao.addCustomer(customer);
		if(b!=null)
		{
			
			System.out.println("Customer is created");
		}
		else
		{
			System.out.println("not able to create book object");
		}
		return b;
		
	}
	
	@GetMapping(path = "/customer")
	public List<Customer> getCustomers()
	{
		
		return dao.viewCustomer(); 
		
	}
	

	@GetMapping(path="/customer/{id}")
	public Customer viewCustomerById(@PathVariable long id) throws NoSuchCustomerException{
		return dao.viewCustomer(id);
	}

	@DeleteMapping(path="deletecustomer/{id}")
	public Customer deleteCustomer(@PathVariable long id) throws NoSuchCustomerException{
		//logger.info("Flight details removed from the database");
		return dao.deleteCustomer(id);
	}

	@PutMapping(path="Update/customer")
public Customer updateCustomer(@RequestBody @Valid Customer customer) throws NoSuchCustomerException {
		
		return this.dao.updateCustomer(customer);			//returns the update loan application
	}
	
	
}
