/**
 * 
 */
package com.nagarro.exitTestBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exitTestBackend.dto.LoginResponse;
import com.nagarro.exitTestBackend.model.Customer;
import com.nagarro.exitTestBackend.repo.CustomerRepo;
import com.nagarro.exitTestBackend.service.CustomerService;
import com.nagarro.exitTestBackend.util.JwtUtil;

/**
 * 
 * @author kanikasharma02
 *
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	CustomerService CustomerService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/user")
	public List<Customer> getUsers() {
		return customerRepo.findAll();
	}


	@PostMapping("/loginUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> loginUser(@RequestBody Customer loginRequest) throws Exception {

		Customer user = authenticate(loginRequest.getUsername(), loginRequest.getPassword());
		if (user == null) {
			System.out.print("User details entered are INCORRECT." + loginRequest.getUsername());
			throw new NullPointerException();
		}
		String token = this.jwtUtil.generateToken(user);
		System.out.print("Login Successful  " + user.getUsername());
		return ResponseEntity.ok(new LoginResponse(token));

	}

	@PostMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer registerUser(@RequestBody Customer customer) throws Exception {
		String tempUsername = customer.getUsername();

		if (tempUsername != null && !"".equals(tempUsername)) {
			Customer UserObj = CustomerService.fetchUserByUsername(tempUsername);

			if (UserObj != null) {
				throw new Exception("Username already exists.");
			}
		}

		Customer userObj = null;
		String pass = customer.getPassword();
		System.out.println("encoded " + passwordEncoder.encode(pass));
		customer.setPassword(passwordEncoder.encode(pass));
		userObj = CustomerService.saveUser(customer);
		return userObj;
	}

	public Customer authenticate(String username, String password) {
		Customer temp = this.customerRepo.findByUsername(username);
		System.out.println(temp);
		if (temp == null) {
			System.out.print("Email entered is INCORRECT." + username);
			throw new UsernameNotFoundException("User not found");
		}
		if (passwordEncoder.matches(password, temp.getPassword())) {
			return temp;
		}

		System.out.println("INCORRECT PASSWORD");
		return null;

	}
}
