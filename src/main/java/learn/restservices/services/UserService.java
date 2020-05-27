package learn.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import learn.restservices.entities.User;
import learn.restservices.exceptions.UserExistsException;
import learn.restservices.exceptions.UserNotFoundException;
import learn.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// get all user
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// create use
	public User createUser(User user) throws UserExistsException {
		User existingUser = userRepository.findByUserName(user.getUserName());
		if (existingUser != null) {
			throw new UserExistsException("User already exists in repository.");
		}
		return userRepository.save(user);
	}

	// get user by id
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not fouund in repository.");
		}
		return user;
	}

	// update user by id
	public User updateUserById(Long id, User user) throws UserNotFoundException {
		Optional<User> userFromRepo = userRepository.findById(id);
		if (!userFromRepo.isPresent()) {
			throw new UserNotFoundException("User not fouund in repository.");
		}
		user.setId(id);
		return userRepository.save(user);
	}

	// delete user by id
	public void deleteUserById(Long id) {
		Optional<User> userFromRepo = userRepository.findById(id);
		if (!userFromRepo.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not fouund in repository.");
		}
		userRepository.deleteById(id);
	}

	// get User By USer name
	public User getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
