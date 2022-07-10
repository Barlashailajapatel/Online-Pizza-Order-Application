package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.exception.NoSuchPizzaException;
import com.cg.exception.PizzaAlreadyExists;
import com.cg.exception.PizzaCreationException;
import com.cg.exception.PizzaOrderAlreadyExists;
import com.cg.model.Pizza;
import com.cg.model.PizzaOrder;


public interface IPizzaService {
	


	public Pizza addPizza(Pizza pizza)throws PizzaCreationException,PizzaAlreadyExists;;
	public Pizza updatePizza(Pizza pizza) throws NoSuchPizzaException;
	public Pizza deletePizza(int pizzaId) throws NoSuchPizzaException;
	public List<Pizza> viewPizzalist();
	public Pizza viewPizza(int pizzaId) throws NoSuchPizzaException;
	public List<Pizza> viewPizzalist(double minCost , double maxCost);
	public List<Pizza> viewPizzalist(String pizzaType);
	

}