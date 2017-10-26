package com.bhawani.springsecurity.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bhawani.singh
 *
 */
@RestController
@RequestMapping("/springsecurity")
public class SpringSecurityController {
	private static final Logger LOGGER = Logger.getLogger(SpringSecurityController.class.getName());

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public String hello(@AuthenticationPrincipal final UserDetails userDetails){
		LOGGER.info(userDetails.getUsername());
		LOGGER.info(userDetails.getPassword());
		
		String userName = userDetails.getUsername();
		
		System.out.println("SpringSecurityController.hello() userName = " + userName);
		
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		
		authorities.forEach(System.out::println);
		
		return "Hello World!!!";
	}
	
	@GetMapping
	@RequestMapping("/secure")
	public String secure(@AuthenticationPrincipal final UserDetails userDetails){
		LOGGER.info(userDetails.getUsername());
		LOGGER.info(userDetails.getPassword());
		
		String userName = userDetails.getUsername();
		
		System.out.println("SpringSecurityController.secure() userName = " + userName);
		
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		
		authorities.forEach(System.out::println);
		
		return "You are secure!!!";
	}
}
