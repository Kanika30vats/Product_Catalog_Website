/**
 * 
 */
package com.nagarro.exitTestBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exitTestBackend.model.Customer;
import com.nagarro.exitTestBackend.repo.CustomerRepo;

/**
 * 
 * @author kanikasharma02
 *
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public Customer saveUser(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer fetchUserByUsername(String username) {
		return customerRepo.findByUsername(username);
	}

	public Customer fetchUserByUsernameAndPassword(String username, String password) {
		return customerRepo.findByUsernameAndPassword(username, password);
	}

}
