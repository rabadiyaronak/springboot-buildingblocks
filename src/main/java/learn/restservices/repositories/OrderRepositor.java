package learn.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import learn.restservices.entities.Order;

public interface OrderRepositor extends JpaRepository<Order, Long> {

}
