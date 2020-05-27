package learn.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.restservices.entities.Order;
import learn.restservices.entities.User;
import learn.restservices.exceptions.OrderNotFoundException;
import learn.restservices.exceptions.UserNotFoundException;
import learn.restservices.repositories.OrderRepositor;
import learn.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepositor orderRepository;

	// get all orders for a user

	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable("userid") Long userId) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		return user.get().getOrders();
	}

	// create order

	@PostMapping("{userid}/orders")
	public void createOrder(@PathVariable("userid") Long userId, @RequestBody Order order)
			throws UserNotFoundException {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		order.setUser(user.get());
		orderRepository.save(order);
	}

	@GetMapping("/orders/{orderid}")
	public Optional<Order> getOrderByOrderId(@PathVariable("orderid") Long orderId) throws OrderNotFoundException {
		Optional<Order> order = orderRepository.findById(orderId);
		if (!order.isPresent()) {
			throw new OrderNotFoundException("Order not found.");
		}
		return order;
	}
}
