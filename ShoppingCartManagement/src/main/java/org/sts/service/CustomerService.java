package org.sts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sts.entities.Customer;
import org.sts.entities.Order;
import org.sts.repository.CustomerRepository;


@Service
@Transactional
public class CustomerService {
	
@Autowired CustomerRepository customerRepository;
	
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Integer id) {
		Optional<Customer> op=customerRepository.findById(id);
		
		if(op.isPresent()){
			return op.get();
		}
		
		return null;
	}

	public List<Order> getCustomerOrders(String email) {
		return customerRepository.getCustomerOrders(email);
	}

	
	

}
