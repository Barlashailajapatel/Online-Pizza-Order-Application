package com.cg.Dao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.NoSuchPizzaException;
import com.cg.exception.PizzaAlreadyExists;
import com.cg.exception.PizzaCreationException;
import com.cg.model.Pizza;
import com.cg.repository.IAdminRepository;
import com.cg.repository.IPizzaRepository;
import com.cg.service.IPizzaService;



@Service
public class PizzaDao implements IPizzaService {
	
	@Autowired
	IPizzaRepository pizzaRepos;
	@Autowired
	AdminDao admindao;
	@Autowired
	IAdminRepository adminrepos;
	
	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(PizzaDao.class);
	
	public String readInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Admin Details to Login");
		System.out.println("Enter Admin Id");
		int adminId = Integer.parseInt(scanner.nextLine());// 1
		System.out.println("Enter Admin name");
		String adminName = scanner.nextLine();// a
		System.out.println("Enter password");
		String password = scanner.nextLine();// xyx
		

		return  adminId+ " " + adminName + " " + password ;
	}

	public Pizza addPizza(Pizza pizza) throws PizzaCreationException, PizzaAlreadyExists {

		String input = readInput();
		String[] strInput = input.split(" ");
		int adminId = Integer.parseInt(strInput[0]);
		String adminName = strInput[1];
		String password = strInput[2];
		

		if (admindao.getAdminName(adminId).equals(adminName) && admindao.getAdminPassword(adminId).equals(password))

		{

			if(pizzaRepos.existsById(pizza.getPizzaId()))
			{
				logger.error("Pizza already exists exception");
				throw new PizzaAlreadyExists("Pizza already exists");
			}
			else
			{
				logger.info("Pizza added successfully");
				return pizzaRepos.save(pizza);
			}
		}

		return null;

	}



	@Override
	public Pizza deletePizza(int pizzaId) {
		// TODO Auto-generated method stub
		Pizza pizza = pizzaRepos.getById(pizzaId);
		pizzaRepos.delete(pizza);
		
		return null;
	}

	@Override
	public Pizza viewPizza(int pizzaId) throws NoSuchPizzaException {
		
		Optional<Pizza> found = pizzaRepos.findById(pizzaId);
		if(found.isPresent()) {
			return found.get();
		}else {
			throw new NoSuchPizzaException("This Pizza does not exist");
		}// TODO Auto-generated method stub
	}

	@Override
	public List<Pizza> viewPizzalist(double minCost, double maxCost) {		
		List<Pizza> list=pizzaRepos.viewPizzaByCost(minCost,maxCost);
		return list;
	}

	@Override
	public List<Pizza> viewPizzalist(String pizzaType) {
		List<Pizza> list=pizzaRepos.viewPizzaByType(pizzaType);
		return list;

		
	}
	@Override
	public List<Pizza> viewPizzalist() {
		// TODO Auto-generated method stub
	
		
			// TODO Auto-generated method stub
			List<Pizza> list = pizzaRepos.findAll();
			for(Pizza c:list)
				logger.info(c.getPizzaId()+ " "+ c.getPizzaName()+" "+c.getPizzaDescription()+" "+c.getPizzaType()+" "+c.getPizzaCost()+""+c.getPizzaCostAfterCoupon());
			return list;
			

			
		
	}

	public Pizza findbyid(long id) throws NoSuchPizzaException
	{
		return pizzaRepos.findById((int) id).orElseThrow(()-> new NoSuchPizzaException("pizza does not exist"));
	}

	@Override
	public Pizza updatePizza(Pizza pizza) throws NoSuchPizzaException {
		// TODO Auto-generated method stub
		Optional<Pizza> optional = pizzaRepos.findById(pizza.getPizzaId());
		if (optional.isPresent()) {
			pizzaRepos.save(pizza);
			return pizza; // returns updated loan application
		} else {
			throw new NoSuchPizzaException("Pizza Data couldn't be Updated! ");
		}
	}
	

}
