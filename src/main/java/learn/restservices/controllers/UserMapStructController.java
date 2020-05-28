package learn.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.restservices.dtos.UserMsDto;
import learn.restservices.entities.User;
import learn.restservices.mappers.UserMapper;
import learn.restservices.repositories.UserRepository;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@GetMapping
	public List<UserMsDto> getAllUser() {
		List<User> users = userRepository.findAll();
		return userMapper.usersToUserMsDtos(users);
	}

	@GetMapping("/{id}")
	public UserMsDto getUserById(@PathVariable Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.get();
		return userMapper.userToUserMsDto(user);
	}

}
