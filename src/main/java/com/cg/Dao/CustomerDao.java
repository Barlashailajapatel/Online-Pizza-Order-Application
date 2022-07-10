package com.cg.Dao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.CustomerAlreadyExists;
import com.cg.exception.CustomerCreationException;
import com.cg.exception.NoSuchCustomerException;
import com.cg.model.Customer;
import com.cg.repository.ICustomerRepository;
import com.cg.service.ICustomerService;



@Service
public class CustomerDao implements ICustomerService {
	
	@Autowired
	ICustomerRepository Customerrepository;
	@Autowired
	AdminDao admindao;
	
	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(CustomerDao.class);
	
	public String readInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Admin Id");
		int adminId = Integer.parseInt(scanner.nextLine());// 1
		System.out.println("Enter Admin name");

		String adminName = scanner.nextLine();// a
		System.out.println("Enter Password");
		String password = scanner.nextLine();//

		return adminId + " " + adminName + " " + password;
	}

	@Override
	public Customer addCustomer(Customer customer) throws CustomerCreationException,CustomerAlreadyExists {

		String input = readInput();
		String[] strInput = input.split(" ");
		int adminId = Integer.parseInt(strInput[0]);
		String adminName = strInput[1];
		String password = strInput[2];

		if (admindao.getAdminName(adminId).equals(adminName) && admindao.getAdminPassword(adminId).equals(password))
				

		{

			if(Customerrepository.existsById(customer.getCustomerId()))
			{
				logger.error("Customer already exists exception");
				throw new CustomerAlreadyExists("Customer already exists");
			}
			else
			{
				logger.info("Customer added successfully");
				return Customerrepository.save(customer);
			}


		}

		return null;

	}


	
	
	@Override
	public List<Customer> viewCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list = Customerrepository.findAll();
		for(Customer c:list)
			logger.info(c.getCustomerId()+ " "+ c.getCustomerName()+" "+c.getCustomerMobile()+" "+c.getCustomerEmail()+""+c.getCustomerAddress());
		return list;
		
		
	}
	

	@Override
	public Customer deleteCustomer(long customerId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		Customerrepository.delete(Customerrepository.getById(customerId));
		return null;
	}


		
	@Override
	public Customer updateCustomer(Customer c) throws NoSuchCustomerException {
		
			// TODO Auto-generated method stub
			Optional<Customer> optional = Customerrepository.findById(c.getCustomerId());
			if (optional.isPresent()) {
				Customerrepository.save(c);
				return c; // returns updated loan application
			} else {
				throw new NoSuchCustomerException("Customer Data couldn't be Updated! ");
			}
		}
		
		
	
	
	public Customer findbyid(long id) throws NoSuchCustomerException
	{
		return Customerrepository.findById(id).orElseThrow(()-> new NoSuchCustomerException("customer does not exist"));
	}

	@Override
	public Customer viewCustomer(long customerId) throws NoSuchCustomerException {		

		Optional<Customer> found = Customerrepository.findById(customerId);
		if(found.isPresent()) {
			return found.get();
		}else 
		{
			throw new NoSuchCustomerException("This Customer does not exist");
		}
	}
}