package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Order_Table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min=1)
	private int orderId;
	@NotBlank(message="order should not be blank")
	private String orderType;
	@NotBlank(message="orderDiscription should not be blank")
	private String orderDescription;
	@Autowired
	@OneToOne
	private Customer customer;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
