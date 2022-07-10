package com.cg.service;
import java.time.LocalDate;
import java.util.List;

import com.cg.exception.NoSuchPizzaOrderException;
import com.cg.exception.PizzaOrderAlreadyExists;
import com.cg.model.PizzaOrder;


public interface IPizzaOrderService {
	public PizzaOrder bookPizzaOrder(PizzaOrder order) throws PizzaOrderAlreadyExists;
	public PizzaOrder updatePizzaOrder(PizzaOrder order) throws NoSuchPizzaOrderException;
	public PizzaOrder cancelPizzaOrder(int bookingOrderId) throws NoSuchPizzaOrderException;
	public PizzaOrder viewPizzaOrder(int bookingOrderId) throws NoSuchPizzaOrderException;
	public List<PizzaOrder> viewOrdersList();
	public List<PizzaOrder> viewOrdersList(LocalDate date);
	public List<PizzaOrder> calculateTotal(String size,int quantity);
}
