package com.bhawani.springsecurity.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;



/**
 * @author bhawani.singh
 * @param <T>
 *
 */
@Component
public class CustomFilter implements Filter {

	@Override
	public void destroy(){
		System.out.println("CustomFilter.destroy()");
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("CustomFilter.doFilter()");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		
		Principal principal = httpServletRequest.getUserPrincipal();
		
		System.out.println("principal = " + principal);
		
		filterChain.doFilter(servletRequest, servletResponse);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CustomFilter.init()");
		
	}

}
