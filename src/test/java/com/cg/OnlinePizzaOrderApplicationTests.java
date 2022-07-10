package com.cg;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cg.Dao.PizzaOrderDao;
import com.cg.exception.NoSuchPizzaOrderException;
import com.cg.model.Coupon;
import com.cg.model.Customer;
import com.cg.model.Pizza;
import com.cg.model.PizzaOrder;
import com.cg.repository.IPizzaOrderRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
@SpringBootTest
class OnlinePizzaOrderApplicationTests { 

	@Autowired
	PizzaOrderDao dao;
	@Autowired
	IPizzaOrderRepository repository;
	@Test
	void testForbookPizzaorder() {
		PizzaOrder pizzaorder=new PizzaOrder();
		
		pizzaorder.setQuantity(3);
		pizzaorder.setTotalCost(18);
	    SimpleDateFormat parseDate=new SimpleDateFormat("MM/dd/yyyy");
	    String date="2022-10-06";
	    LocalDate localDate=LocalDate.parse(date);
	    pizzaorder.setOrderDate(localDate);
	    pizzaorder.setSize("Abcd");
	    pizzaorder.setTransactionMode("whatsapp");
	   Customer customer=new Customer();
	   customer.setCustomerId(5);
	   Coupon coupon=new Coupon();
	   coupon.setCouponId(1);
	   Pizza pizza=new Pizza();
	  pizza.setPizzaId(25);
	  pizzaorder.setCustomer(customer);
	  pizzaorder.setCoupon(coupon);
	  pizzaorder.setPizza(pizza);
	  
	 
	PizzaOrder str=null;
	 try {
         str=dao.bookPizzaOrder(pizzaorder);
         String str1 = "PizzaOrdered successfully";
         assertEquals("Pizza added successfully",str1);
     }
     catch(Exception e) {
         e.printStackTrace();
     }  

	
	}
	@Test
	public void testForUpdate() {
		 PizzaOrder pizzaorder=repository.findById(10).get();
		 pizzaorder.setTotalCost(550);
		 
		 repository.save(pizzaorder);
		 assertNotEquals(550, repository.findById(10).get().getTotalCost());
	
	}
	  @Test
	    public void testFordeletePizzaOrder() throws NoSuchPizzaOrderException{
		  Integer id=59;
	        boolean isExistBeforeDelete = repository.findById(id).isPresent();
	       repository.deleteById(id);
	      boolean notExistsAfterDelete    = repository.findById(id).isPresent();
	      assertTrue(isExistBeforeDelete);
	      assertFalse(notExistsAfterDelete);
		}
	  @Test
	    public void testForViewPizzaByCost() {
		  List<PizzaOrder>list=dao.viewOrdersList();
	    	 assertThat(list).size().isGreaterThan(0);
	  }

	@Test
	public void testForViewPizzaOrderById() {
		List<PizzaOrder>list=dao.viewOrdersList();
   	 assertThat(list).size().isGreaterThan(0);	
	}


@Test
public void testForCalculateTital() {
 List<PizzaOrder>list=dao.calculateTotal("medium", 78);
 assertEquals(5,list);
}
}
