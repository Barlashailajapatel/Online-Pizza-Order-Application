package com.cg.Dao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.CouponAlreadyExists;
import com.cg.exception.NoSuchCouponException;
import com.cg.model.Coupon;
import com.cg.repository.IAdminRepository;
import com.cg.repository.ICouponRepository;
import com.cg.service.ICouponService;

@Service
public class CouponDao implements ICouponService {
	@Autowired
	ICouponRepository CouponRepos;
	@Autowired
	AdminDao admindao;
	@Autowired
	IAdminRepository adminrepos;
	
	Logger 
	logger=org.slf4j.LoggerFactory.getLogger(CouponDao.class);
	
	public String readInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Admin Details to Login");
		System.out.println("Enter Admin Id");
		int adminId = Integer.parseInt(scanner.nextLine());// 1
		System.out.println("Enter Admin name");
		String adminName = scanner.nextLine();// a
		System.out.println("Enter password");
		String password = scanner.nextLine();// xyx
		

		return  adminId+ " " + adminName + " " + password ;
	}
	@Override
	public Coupon addCoupon(Coupon coupon) throws CouponAlreadyExists{

			String input = readInput();
			String[] strInput = input.split(" ");
			int adminId = Integer.parseInt(strInput[0]);
			String adminName = strInput[1];
			String password = strInput[2];
			

			if (admindao.getAdminName(adminId).equals(adminName) && admindao.getAdminPassword(adminId).equals(password))

			{

				if(CouponRepos.existsById(coupon.getCouponId()))
				{
					logger.error("Coupon already exists exception");
					throw new CouponAlreadyExists("Coupon already exists");
				}
				else
				{
					logger.info("Pizza added successfully");
					return CouponRepos.save(coupon);
				}
			}

		
		return null;
	}

	@Override
	public Coupon deleteCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> viewCoupons() {
		// TODO Auto-generated method stub
		List<Coupon> list = CouponRepos.findAll();
		for(Coupon c:list)
			logger.info(c.getCouponId()+ " "+ c.getCouponName()+" "+c.getCouponType()+" "+c.getCouponDescription()+" "+c.getCouponPizzaId());
		return list;
	}
	@Override
	public Coupon editCoupon(Coupon coupon) throws NoSuchCouponException {
		// TODO Auto-generated method stub
		Optional<Coupon> optional = CouponRepos.findById(coupon.getCouponId());
		if (optional.isPresent()) {
			CouponRepos.save(coupon);
			return coupon; // returns updated loan application
		} else {
			throw new NoSuchCouponException("Coupon Data couldn't be Updated! ");
		}
	}

	
}

