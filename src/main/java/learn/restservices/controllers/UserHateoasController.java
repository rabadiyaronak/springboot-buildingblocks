package learn.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import learn.restservices.entities.Order;
import learn.restservices.entities.User;
import learn.restservices.exceptions.UserNotFoundException;
import learn.restservices.repositories.UserRepository;
import learn.restservices.services.UserService;

@RestController
@RequestMapping(value = "/hateoas/users")
@Validated
public class UserHateoasController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping
	public CollectionModel<User> getAllUsers() throws UserNotFoundException {
		List<User> users = userService.getAllUsers();
		for (User user : users) {
			Long userId = user.getId();
			Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userId).withSelfRel();
			user.add(selfLink);

			CollectionModel<Order> ordersResources = WebMvcLinkBuilder.methodOn(OrderHateoasController.class)
					.getAllOrders(userId);

			Link orderLink = WebMvcLinkBuilder.linkTo(ordersResources).withRel("all-orders");
			user.add(orderLink);
		}
		Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).withSelfRel();

		return CollectionModel.of(users, selfLink);
	}

	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") Long id) {
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();
			Long userId = user.getId();
			Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userId).withSelfRel();
			return EntityModel.of(user, selfLink);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

}
