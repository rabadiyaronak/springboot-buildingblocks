package learn.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.restservices.entities.User;
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
	public User createUser(User user) {
		return userRepository.save(user);
	}

	// get user by id
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	// update user by id
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	// delete user by id
	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}

	// get User By USer name
	public User getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
