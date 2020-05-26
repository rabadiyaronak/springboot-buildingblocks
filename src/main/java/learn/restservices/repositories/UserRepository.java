package learn.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.restservices.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
}
