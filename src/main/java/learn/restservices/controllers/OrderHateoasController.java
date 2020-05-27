package learn.restservices.controllers;

import java.util.Optional;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.restservices.entities.Order;
import learn.restservices.entities.User;
import learn.restservices.exceptions.UserNotFoundException;
import learn.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/hateoad/users")
public class OrderHateoasController {

	private UserRepository userRepository;

	public OrderHateoasController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/{userid}/orders")
	public CollectionModel<Order> getAllOrders(@PathVariable("userid") Long userId) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		return CollectionModel.of(user.get().getOrders());
	}

}
