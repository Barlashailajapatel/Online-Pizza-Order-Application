package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Dao.CouponDao;
import com.cg.exception.CouponAlreadyExists;
import com.cg.exception.NoSuchCouponException;
import com.cg.model.Coupon;


@RestController
@RequestMapping("/api")
public class CouponController {

	@Autowired
	CouponDao couponDao;

	@PostMapping(path = "/coupon/create")
	public Coupon addCoupon(@Valid@RequestBody Coupon coupon) throws CouponAlreadyExists {
		Coupon b = couponDao.addCoupon(coupon);
		if (b != null) {

			System.out.println("Coupon is created");
		} else {
			System.out.println("not able to create Coupon object");
		}
		return b;

	}

	@GetMapping(path = "/coupon")
	public List<Coupon> getCoupons() {
		return couponDao.viewCoupons();
	}

	@PutMapping(path = "Update/coupon")
	public Coupon updateCoupon(@RequestBody @Valid Coupon coupon) throws NoSuchCouponException {

		return this.couponDao.editCoupon(coupon);
	}

}
