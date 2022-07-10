package com.cg.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Pizza_Order_Table")
public class PizzaOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min=1)
private int bookingOrderId;
private LocalDate orderDate;
private String transactionMode;
private int quantity;
@NotBlank(message="adminName should not be blank")
private String size;

private double totalCost;
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name="customer_id")
private Customer customer;
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name="pizza_id")
private Pizza pizza;
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name="coupon_id")
private Coupon coupon;

public int getBookingOrderId() {
    return bookingOrderId;
}
public void setBookingOrderId(int bookingOrderId) {
    this.bookingOrderId = bookingOrderId;
}
public LocalDate getOrderDate() {
    return orderDate;
}
public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
}
public String getTransactionMode() {
    return transactionMode;
}
public void setTransactionMode(String transactionMode) {
    this.transactionMode = transactionMode;
}
public int getQuantity() {
    return quantity;
}
public void setQuantity(int quantity) {
    this.quantity = quantity;
}
public String getSize() {
    return size;
}
public void setSize(String size) {
    this.size = size;
}
public double getTotalCost() {
    return totalCost;
}
public void setTotalCost(double totalCost) {
    this.totalCost = totalCost;
}
public Pizza getPizza() {
    return pizza;
}
public void setPizza(Pizza pizza) {
    this.pizza = pizza;
}
public Coupon getCoupon() {
    return coupon;
}
public void setCoupon(Coupon coupon) {
    this.coupon = coupon;
}
public Customer getCustomer() {
    return customer;
}
public void setCustomer(Customer customer) {
    this.customer = customer;
}

}