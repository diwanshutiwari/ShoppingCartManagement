package org.sts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.sts.entities.Customer;
import org.sts.entities.Order;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByEmail(String email);

	@Query("select o from Order o where o.customer.email=?1")
	List<Order> getCustomerOrders(String email);
	
}
