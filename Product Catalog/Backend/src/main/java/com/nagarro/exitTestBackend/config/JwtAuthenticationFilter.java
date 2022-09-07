package com.nagarro.exitTestBackend.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nagarro.exitTestBackend.service.CustomerAuthentication;

import com.nagarro.exitTestBackend.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * 
 * @author kanikasharma02
 *
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomerAuthentication customerAuthDetails;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException, ExpiredJwtException, NullPointerException {
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				if (this.jwtUtil.isTokenExpired(jwtToken)) {
					System.out.println("---->Token expired!");
					throw new ExpiredJwtException(null, null, jwtToken);
				}
				username = this.jwtUtil.extractUsername(jwtToken);
				System.out.println(username);

			} catch (Exception e) {
				e.printStackTrace();
			}
			UserDetails userdetails = this.customerAuthDetails.loadUserByUsername(username);
			if (userdetails == null) {
				throw new NullPointerException("Userdetails are null");
			}
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userdetails, null, userdetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("Token is not validated");
			}
		}

		filterChain.doFilter(request, response);

	}

}
