package com.cg.service;


import java.util.List;

import com.cg.exception.CouponAlreadyExists;
import com.cg.exception.NoSuchCouponException;
import com.cg.model.Coupon;



public interface ICouponService {
public Coupon addCoupon(Coupon coupon) throws CouponAlreadyExists;
public Coupon editCoupon(Coupon coupon) throws NoSuchCouponException;
public Coupon deleteCoupon(Coupon coupon);
public List<Coupon> viewCoupons();


}
