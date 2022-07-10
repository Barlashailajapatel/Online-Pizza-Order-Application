package com.cg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.model.PizzaOrder;

	

	@Repository
	public interface IPizzaOrderRepository  extends JpaRepository<PizzaOrder, Integer> {


		@Query(value="select *from Pizza_order_table where size=?1 and quantity=?2",nativeQuery = true)
		public List<PizzaOrder> viewPizzaOrderByCost(String size, int quantity);
		
		@Query(value="select *from Pizza_order_table where order_date=?1",nativeQuery = true)

		public List<PizzaOrder> viewPizzaOrderByDate(LocalDate date);
	}

	
		
	