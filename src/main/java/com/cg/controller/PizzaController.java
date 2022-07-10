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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Dao.PizzaDao;
import com.cg.exception.NoSuchPizzaException;
import com.cg.exception.PizzaAlreadyExists;
import com.cg.exception.PizzaCreationException;
import com.cg.model.Pizza;



@RestController
@RequestMapping("/api")
public class PizzaController {
	@Autowired
	PizzaDao pizzadao;


	
	@PostMapping(path = "/pizza/create")
	public Pizza addPizza(@Valid@RequestBody Pizza pizza) throws PizzaAlreadyExists, PizzaCreationException
	{
		Pizza p=pizzadao.addPizza(pizza);
		if(p!=null)
		{
			
			System.out.println("Pizza is created");
		}
		else
		{
			System.out.println("not able to create Pizza object");
		}
		return p;
		
	}
	
	@GetMapping(path = "/pizza")
	public List<Pizza> getPizzas()
	{	
		return pizzadao.viewPizzalist(); 	
	}
	
	@GetMapping(path="/pizza/{id}")
	public Pizza viewPizzaById(@PathVariable int id) throws NoSuchPizzaException{
		return pizzadao.viewPizza(id);
	}
	
	@RequestMapping(value = "/pizza/pizzaType/{pizzaType}", method = RequestMethod.GET)
	public List<Pizza> viewPizzaByType(@PathVariable String pizzaType) throws NoSuchPizzaException{
		return pizzadao.viewPizzalist(pizzaType);
	}
	
	@RequestMapping(value = "/pizza/pizzaCost/{minCost}/{maxCost}", method = RequestMethod.GET)
	public List<Pizza> viewPizzaByCost(@PathVariable double minCost,@PathVariable double maxCost) throws NoSuchPizzaException{
		return pizzadao.viewPizzalist(minCost,maxCost);
	}
	@DeleteMapping(path="pizza/{id}")
	public Pizza deletePizza(@PathVariable int id) throws NoSuchPizzaException {
		
		return pizzadao.deletePizza(id);
	}
	
	@PutMapping(path="Update/pizza")
public Pizza updateStatus(@RequestBody @Valid Pizza pizza) throws NoSuchPizzaException {
		
		return this.pizzadao.updatePizza(pizza);			//returns the update loan application
	}
	

	}



