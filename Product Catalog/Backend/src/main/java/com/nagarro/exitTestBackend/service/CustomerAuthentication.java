package com.nagarro.exitTestBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.exitTestBackend.model.Customer;
import com.nagarro.exitTestBackend.repo.CustomerRepo;

/**
 * 
 * @author kanikasharma02
 *
 * @param <findByUsername>
 */
@Service
public class CustomerAuthentication<findByUsername> implements UserDetailsService {

	@Autowired
	private CustomerRepo customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer temp = customerRepository.findByUsername(username);
		if (temp != null) {
			List<GrantedAuthority> authority = new ArrayList<>();
			authority.add(new SimpleGrantedAuthority(temp.getUsername()));
			System.out.println(authority);
			return new User(temp.getUsername(), temp.getPassword(), authority);
		} else
			throw new UsernameNotFoundException("User not found");
	}

}
