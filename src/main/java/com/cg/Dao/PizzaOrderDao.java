package com.cg.Dao;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.NoSuchPizzaException;
import com.cg.exception.NoSuchPizzaOrderException;
import com.cg.exception.PizzaAlreadyExists;
import com.cg.exception.PizzaCreationException;
import com.cg.exception.PizzaOrderAlreadyExists;
import com.cg.model.Pizza;
import com.cg.model.PizzaOrder;
import com.cg.repository.IAdminRepository;
import com.cg.repository.IPizzaOrderRepository;
import com.cg.repository.IPizzaRepository;
import com.cg.repository.IUserRepository;
import com.cg.service.IPizzaOrderService;


@Service
public class PizzaOrderDao implements IPizzaOrderService {
	
	@Autowired
    IPizzaOrderRepository pizzaorderRepository;

    @Autowired
    IUserRepository userRepository;
    Logger logger = org.slf4j.LoggerFactory.getLogger(PizzaOrderDao.class);

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User Details to Login");
        System.out.println("Enter User Id");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter User name");
        String userName = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        scanner.close();
        if (userRepository.getUserName(userId).equals(userName) && userRepository.getUserPassword(userId).equals(password))

        {
            logger.info("Login Succesfully");
            return true;
        }
        logger.warn("Invalid Login,User Not Found");
        return false;

    }

    @Override
    public PizzaOrder bookPizzaOrder(PizzaOrder pizza) throws PizzaOrderAlreadyExists {
        if (login()) {
            if (pizzaorderRepository.existsById(pizza.getBookingOrderId())) {
                logger.error("PizzaOrder already exists exception");
                throw new PizzaOrderAlreadyExists("PizzaOrder already exists");
            } else {
                logger.info("PizzaOrder added successfully");
                return pizzaorderRepository.save(pizza);
            }
        }

        return null;
    }

    @Override
    public PizzaOrder updatePizzaOrder(PizzaOrder order) throws NoSuchPizzaOrderException {
        Optional<PizzaOrder> optional = pizzaorderRepository.findById(order.getBookingOrderId());
        if (optional.isPresent()) {
            pizzaorderRepository.save(order);
            return order;
        } else {
            throw new NoSuchPizzaOrderException("PizzaOrder Data couldn't be Updated! ");
        }
    }

    @Override
    public PizzaOrder cancelPizzaOrder(int bookingOrderId) {
        PizzaOrder order = pizzaorderRepository.getById(bookingOrderId);
        pizzaorderRepository.delete(order);
        return null;

    }

    @Override
    public PizzaOrder viewPizzaOrder(int bookingOrderId) throws NoSuchPizzaOrderException {
        Optional<PizzaOrder> found = pizzaorderRepository.findById(bookingOrderId);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new NoSuchPizzaOrderException("This Pizza does not exist");
        }
    }

    @Override
    public List<PizzaOrder> viewOrdersList() {
        List<PizzaOrder> list = pizzaorderRepository.findAll();
        for (PizzaOrder c : list)
            logger.info(c.getBookingOrderId() + " " + c.getSize() + " " + c.getQuantity() + " " + c.getTotalCost() + " "
                    + c.getOrderDate() + " " + c.getPizza() + "" + c.getCoupon() + "" + c.getPizza() + ""
                    + c.getTransactionMode());
        return list;
    }

    @Override
    public List<PizzaOrder> viewOrdersList(LocalDate date) {
        List<PizzaOrder> list = pizzaorderRepository.viewPizzaOrderByDate(date);
        return list;
    }

    @Override
    public List<PizzaOrder> calculateTotal(String size, int quantity) {
    	List<PizzaOrder> list=pizzaorderRepository.viewPizzaOrderByCost(size,quantity);
        return list;
    }
    
}
	