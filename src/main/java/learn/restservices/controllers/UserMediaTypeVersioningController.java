package learn.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import learn.restservices.dtos.UserDtoV1;
import learn.restservices.dtos.UserDtoV2;
import learn.restservices.entities.User;
import learn.restservices.exceptions.UserNotFoundException;
import learn.restservices.services.UserService;

@RestController
@RequestMapping("/versioning/mediatype/users")
public class UserMediaTypeVersioningController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/{id}", produces = "application/vnd.learn.springboot.app-v1+json")
	public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();
			return modelMapper.map(user, UserDtoV1.class);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@GetMapping(value = "/{id}", produces = "application/vnd.learn.springboot.app-v2+json")
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> userOptional = userService.getUserById(id);
			User user = userOptional.get();
			return modelMapper.map(user, UserDtoV2.class);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
}
