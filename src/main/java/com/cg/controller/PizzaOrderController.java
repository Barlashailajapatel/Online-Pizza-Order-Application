package com.cg.controller;
import java.time.LocalDate;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Dao.PizzaDao;
import com.cg.Dao.PizzaOrderDao;
import com.cg.exception.NoSuchPizzaException;
import com.cg.exception.NoSuchPizzaOrderException;
import com.cg.exception.PizzaAlreadyExists;
import com.cg.exception.PizzaCreationException;
import com.cg.exception.PizzaOrderAlreadyExists;
import com.cg.model.Pizza;
import com.cg.model.PizzaOrder;


@RestController
@RequestMapping("/api")
public class PizzaOrderController {
	
	@Autowired
	PizzaOrderDao pizzaOrderdao;
	@PostMapping(path = "/pizzaOrder/create")
	public PizzaOrder bookPizza(@Valid@RequestBody PizzaOrder pizza) throws  PizzaOrderAlreadyExists
	{
	//LocalDate PDate = pizza.getOrderDate();
		PizzaOrder p=pizzaOrderdao.bookPizzaOrder(pizza);
		if(p!=null)
		{
			
			System.out.println("PizzaOrder is created");
		}
		else
		{
			System.out.println("not able to create PizzaOrder object");
		}
		return p;
		
	}
	@GetMapping(path = "/pizzaOrder")
	public List<PizzaOrder> getOrders()
	{	
		return pizzaOrderdao.viewOrdersList(); 	
	}
	
	@GetMapping(path="/pizzaOrder/{id}")
	public PizzaOrder viewPizzaOrderById(@PathVariable int id) throws NoSuchPizzaOrderException{
		return pizzaOrderdao.viewPizzaOrder(id);
	}
	@RequestMapping(value = "/pizzaOrder/pizzaOrderCaculate/{size}/{quantity}", method = RequestMethod.GET)
	public List<PizzaOrder> viewPizzaOrderByCost(@PathVariable String size,@PathVariable int quantity) throws NoSuchPizzaException{
		return pizzaOrderdao.calculateTotal(size,quantity);
	}
	@PostMapping("/pizzaOrder/pizzaOrderDate/{date}")
	public List<PizzaOrder> viewPizzaOrderByDate(@Valid@RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws NoSuchPizzaException{
		return pizzaOrderdao.viewOrdersList(date);
	}
	@PutMapping(path="Update/pizzaOrder")
	public PizzaOrder updateStatus(@RequestBody @Valid PizzaOrder order) throws NoSuchPizzaOrderException {
			
			return this.pizzaOrderdao.updatePizzaOrder(order);		
		}
	@DeleteMapping(path="pizzaOrder/{bookingOrderid}")
	public PizzaOrder deletePizza(@PathVariable int bookingOrderid) throws NoSuchPizzaOrderException {
		
		return pizzaOrderdao.cancelPizzaOrder(bookingOrderid);
	}
	
}
