package com.bhawani.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author bhawani.singh
 *
 */

//@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
public class SpringSecurityEgApp extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth.authenticationProvider(authenticationProvider) take data form database 
		auth.inMemoryAuthentication()
			.withUser("bhawani").password("bhawani").roles("ADMIN")
			.and()
			.withUser("bhawani1").password("bhawani1").roles("USER"); 
			// now change permitAll to  fullyAuthenticated
			
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	
		httpSecurity
			.authorizeRequests()
			//.antMatchers("**/springsecurity").hasRole("ADMIN")
			//.antMatchers("**/springsecurity").authenticated()
			//.antMatchers("**/app/**")
			.anyRequest()
			//.anyRequest().hasRole("USER")
			.fullyAuthenticated()
			//.permitAll()
			.and()
			//.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
			//.formLogin().loginPage("login").permitAll()
			.httpBasic();			
			
		// Adds CSRF support. This is activated by default when using WebSecurityConfigurerAdapter's default constructor. You can disable it using:
		httpSecurity.csrf().disable();
		
	}

	@Bean
	public CustomFilter customFilter() {
		return new CustomFilter();
	}
}
