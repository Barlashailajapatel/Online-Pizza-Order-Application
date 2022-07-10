package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Pizza_Table")
public class Pizza {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	@NotNull(message="Pizza Id should not be null")
private int pizzaId;
	@NotBlank(message="PizzaName should not be blank")
private String pizzaName;
@NotBlank(message="pizzaType should not be blank")
private String pizzaType;
@NotBlank(message="pizzaDiscription should not be blank")
private String pizzaDescription;
@NotNull(message="PizzaCost should not be null")
private double pizzaCost;
@NotNull(message="PizzaCostAfterCoupon should not be null")
private double pizzaCostAfterCoupon;


public int getPizzaId() {
	return pizzaId;
}
public void setPizzaId(int pizzaId) {
	this.pizzaId = pizzaId;
}
public String getPizzaName() {
	return pizzaName;
}
public void setPizzaName(String pizzaName) {
	this.pizzaName = pizzaName;
}
public String getPizzaType() {
	return pizzaType;
}
public void setPizzaType(String pizzaType) {
	this.pizzaType = pizzaType;
}
public String getPizzaDescription() {
	return pizzaDescription;
}
public void setPizzaDescription(String pizzaDescription) {
	this.pizzaDescription = pizzaDescription;
}
public double getPizzaCost() {
	return pizzaCost;
}
public void setPizzaCost(double pizzaCost) {
	this.pizzaCost = pizzaCost;
}
public double getPizzaCostAfterCoupon() {
	return pizzaCostAfterCoupon;
}
public void setPizzaCostAfterCoupon(double pizzaCostAfterCoupon) {
	this.pizzaCostAfterCoupon = pizzaCostAfterCoupon;

}

}
