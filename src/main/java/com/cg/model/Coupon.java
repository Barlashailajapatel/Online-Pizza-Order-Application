package com.cg.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Coupon_Table")
public class Coupon {
	@Id
	@Range(min=1)
private int couponId;
	@NotBlank(message="couponName should not be blank")
private String couponName;
	@NotBlank(message="couponType should not be blank")
private String couponType;
	@NotBlank(message="couponDescrition should not be blank")
private String couponDescription;
/*
 * @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
 * 
 * @JoinColumn(name="pizza_id")
 */
private int couponPizzaId;
public int getCouponId() {
	return couponId;
}
public void setCouponId(int couponId) {
	this.couponId = couponId;
}
public String getCouponName() {
	return couponName;
}
public void setCouponName(String couponName) {
	this.couponName = couponName;
}
public String getCouponType() {
	return couponType;
}
public void setCouponType(String couponType) {
	this.couponType = couponType;
}
public String getCouponDescription() {
	return couponDescription;
}
public void setCouponDescription(String couponDescription) {
	this.couponDescription = couponDescription;
}
public int getCouponPizzaId() {
	return couponPizzaId;
}
public void setCouponPizzaId(int couponPizzaId) {
	this.couponPizzaId = couponPizzaId;
}



}
