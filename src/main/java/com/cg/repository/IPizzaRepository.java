package com.cg.repository;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.exception.PizzaIdNotFoundException;
import com.cg.model.Pizza;

@Repository
	public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {
	 
@Query(value="select *from pizza_table where pizza_type= ?1",nativeQuery = true)
	public List<Pizza> viewPizzaByType(String pizzaType);
	

	@Query(value="	select *from pizza_table where pizza_cost>=?1 and pizza_cost<=?2",nativeQuery = true)
	public List<Pizza> viewPizzaByCost(double minCost, double maxCost);
}
