package com.nagarro.exitTestBackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.exitTestBackend.model.Customer;

/**
 * 
 * @author kanikasharma02
 *
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public Customer findByUsername(String username);

	public Customer findByUsernameAndPassword(String username, String password);

}
