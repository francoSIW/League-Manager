package it.uniroma3.Filters;

import it.uniroma3.controller.AmministratoreController;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(filterName = "AmministratoreFiltro", urlPatterns = {"faces/paginefiltrate/*"})

public class AmministratoreFiltro implements Filter {

	/**
	 * Checks if user is logged in. If not it redirects to the login.xhtml page.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Get the loginBean from session attribute
		AmministratoreController ac = (AmministratoreController) ((HttpServletRequest)request).getSession().getAttribute("AmministratoreController");

		// For the first application request there is no loginBean in the session so user needs to log in
		// For other requests loginBean is present but we need to check if user has logged in successfully
		if (ac == null || !ac.isLoggedIn()) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse)response).sendRedirect("/loginAmministratore.jsp");//contextPath + 
		}

		chain.doFilter(request, response);

	}
	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
			}

}
