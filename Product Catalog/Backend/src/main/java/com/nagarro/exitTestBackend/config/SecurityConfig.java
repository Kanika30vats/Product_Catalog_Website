package com.nagarro.exitTestBackend.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author kanikasharma02
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/allProduct").permitAll()
		.antMatchers("/searchByName/{name}").permitAll()
		.antMatchers("/searchByName/{brand}").permitAll()
		.antMatchers("/searchByNameBrandCode").permitAll()
		.antMatchers("/{pId}").permitAll()
		.antMatchers("/desc/{pId}").permitAll()
		.antMatchers("/sortbyPriceAsc").permitAll()
		.antMatchers("/sortbyPriceDesc").permitAll()
		.antMatchers("/singleProduct/{pId}").permitAll()
		.antMatchers("/searchPincode").permitAll()
		.antMatchers("/user").permitAll()
		.antMatchers("/registerUser").permitAll()
		.antMatchers("/loginUser").permitAll()
		.anyRequest()
		.authenticated();
		
		
	}
	

}
