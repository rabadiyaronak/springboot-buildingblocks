package learn.restservices.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import learn.restservices.entities.User;
import learn.restservices.exceptions.UserExistsException;
import learn.restservices.exceptions.UserNameNotFoundException;
import learn.restservices.exceptions.UserNotFoundException;
import learn.restservices.services.UserService;

@Api(tags = "User Management Restful Services", value = "UserController", description = "Controller for User Management Service")
@RestController
@Validated
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Retrive list of Users")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@ApiOperation(value = "Create New User")
	@PostMapping
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder) {
		try {
			User createdUser = userService.createUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.pathSegment("users/{id}").buildAndExpand(createdUser.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (UserExistsException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@ApiOperation(value = "Search by User Id")
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			return userService.getUserById(id).get();
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@ApiOperation(value = "Update user by user id")
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}

	@GetMapping("/byUserName/{username}")
	public User getUserByUserName(@PathVariable("username") String userName) throws UserNameNotFoundException {
		return userService.getUserByUserName(userName);
	}

}
